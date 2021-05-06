package com.school.management.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.school.management.util.CommonConstants.DateFormat;


/**
 * 
 * @author
 *
 * @param <T> The FilterUtil Class is define a Filter of any object with one
 *            parameter and Multiple Parameter also Paging
 * 
 */
@Component
public class FilterUtil<T> {

	public Specification<T> getSpecification(Map<String, String> filterParameter) {
		return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			int a = 0;
			Predicate[] v = new Predicate[filterParameter.size()];
			for (Map.Entry<String, String> entry : filterParameter.entrySet()) {

				v[a++] = criteriaBuilder.equal(root.get(entry.getKey()), entry.getValue());
			}

			predicates.add(criteriaBuilder.and(v));

			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

		};

	}

	public Specification<T> getSpecification(List<SearchCriteria> list) {
		return new Specification<T>() {

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> predicates = new ArrayList<>();
				for (SearchCriteria criteria : list) {
					switch (criteria.getOperation()) {
					case EQUAL:
						predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
						break;
					case COMPOSITE:
						predicates.add(builder.equal(root.get(criteria.getKey()).get(criteria.getSecondaryKey()),
								criteria.getValue()));
						break;
					case NESTED_COMPOSITE:
						predicates.add(builder.equal(root.get(criteria.getKey()).get(criteria.getSecondaryKey())
								.get(criteria.getSecondSecondaryKey()), criteria.getValue()));
						break;
					case GREATER_THAN:
						predicates
								.add(builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
						break;
					case LESS_THAN:
						predicates.add(builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
						break;
					case GREATER_THAN_EQUAL:
						predicates.add(builder.greaterThanOrEqualTo(root.get(criteria.getKey()),
								criteria.getValue().toString()));
						break;
					case LESS_THAN_EQUAL:
						predicates.add(
								builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
						break;
					case NOT_EQUAL:
						predicates.add(builder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
						break;
					case MATCH:
						predicates.add(builder.like(builder.lower(root.get(criteria.getKey())),
								"%" + criteria.getValue().toString().toLowerCase() + "%"));
						break;
					case MATCH_END:
						predicates.add(builder.like(builder.lower(root.get(criteria.getKey())),
								criteria.getValue().toString().toLowerCase() + "%"));
						break;
					case MATCH_START:
						predicates.add(builder.like(builder.lower(root.get(criteria.getKey())),
								"%" + criteria.getValue().toString().toLowerCase()));
						break;
					case IN:
						predicates.add(builder.in(root.get(criteria.getKey())).value(criteria.getValue()));
						break;
					case NOT_IN:
						predicates.add(builder.not(root.get(criteria.getKey())).in(criteria.getValue()));
						break;
					case DATE_BETWEEN:
						@SuppressWarnings("unchecked")
						Map<String, Date> map = (Map<String, Date>) criteria.getValue();
						predicates.add(builder.between(root.get(criteria.getKey()), map.get(CommonConstants.FROM),
								map.get(CommonConstants.TO)));
						break;
					case DATE_GREATER_THAN:
						predicates.add(builder.greaterThan(root.get(criteria.getKey()), (Date) criteria.getValue()));
						break;
					case DATE_LESS_THAN_OR_EQAUL:
						predicates.add(
								builder.lessThanOrEqualTo(root.get(criteria.getKey()), (Date) criteria.getValue()));
						break;
					case DATE_GREATER_THAN_OR_EQAUL:
						predicates.add(
								builder.greaterThanOrEqualTo(root.get(criteria.getKey()), (Date) criteria.getValue()));
						break;
					case IS_NULL:
						predicates.add(builder.isNull(root.get(criteria.getKey())));
						break;
					case IS_NOT_NULL:
						predicates.add(builder.isNotNull(root.get(criteria.getKey())));
						break;

					case VISIBILITY_TRUE:
						@SuppressWarnings("unchecked")
						Map<String, String> mapt = (Map<String, String>) criteria.getValue();
						String onet = mapt.get("keyOne");
						String twot = mapt.get("keytwo");
						Expression<Float> xl = builder.diff(
								builder.function("to_date", Float.class,
										builder.function("to_char", Float.class, builder.currentTimestamp(),
												builder.literal(DateFormat.DD_MM_YYYY_HH24MISS)),
										builder.literal(DateFormat.DD_MM_YYYY_HH24MISS)),
								builder.function("to_date", Float.class,
										builder.function("to_char", Float.class, root.get(criteria.getKey()),
												builder.literal(DateFormat.DD_MM_YYYY_HH24MISS)),
										builder.literal(DateFormat.DD_MM_YYYY_HH24MISS)));
						Expression<Float> yl =builder.function("NVL",Float.class, root.get(onet).get(twot),builder.prod(xl, 24 * 60));
						predicates.add(builder.le(builder.prod(xl, 24 * 60),yl));
						break;
					case VISIBILITY_FALSE:
						@SuppressWarnings("unchecked")
						Map<String, String> mapf = (Map<String, String>) criteria.getValue();
						String onef = mapf.get("keyOne");
						String twof = mapf.get("keytwo");
						Expression<Float> xg = builder.diff(
								builder.function("to_date", Float.class,
										builder.function("to_char", Float.class, builder.currentTimestamp(),
												builder.literal(DateFormat.DD_MM_YYYY_HH24MISS)),
										builder.literal(DateFormat.DD_MM_YYYY_HH24MISS)),
								builder.function("to_date", Float.class,
										builder.function("to_char", Float.class, root.get(criteria.getKey()),
												builder.literal(DateFormat.DD_MM_YYYY_HH24MISS)),
										builder.literal(DateFormat.DD_MM_YYYY_HH24MISS)));
						predicates.add(builder.ge(builder.prod(xg, 24 * 60 - 1), root.get(onef).get(twof)));
						break;
					default:
						break;
					}
				}
				return builder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};

	}
}

