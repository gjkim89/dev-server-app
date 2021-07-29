package com.dev.server.specification;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.dev.server.model.Member;

public class MemberSpecs {
	
	public static Specification<Member> searchWith(Map<String, Object> keyword){
		return (Specification<Member>) ((root, query, builder) -> {
			List<Predicate> predicate= getPredicateWithSearch(keyword, root, builder);
			return builder.and(predicate.toArray(new Predicate[predicate.size()]));
		});
	}
	
	private static List<Predicate> getPredicateWithSearch(Map<String, Object> keyword, Root<Member> root, CriteriaBuilder builder){
		List<Predicate> predicate = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat();
		
		for(String key : keyword.keySet()) {
			
			if(key.equals("id")) {
				
				predicate.add(builder.equal(
					root.get(key), keyword.get(key)
				));
				
			}else if(key.equals("name")) {
				
				predicate.add(builder.equal(
					root.get(key), keyword.get(key)
				));
				
				
			}else if(key.equals("age")) {
				
				predicate.add(builder.equal(
					root.get(key), keyword.get(key)
				));
				
				
			}else if(key.equals("sex")) {
				
				predicate.add(builder.equal(
					root.get(key), keyword.get(key)
				));
				
				
			}else if(key.equals("startTime")) {
				
				try {
					Date startDate = sdf.parse(sdf.format(keyword.get("startTime")));
					Date endDate = sdf.parse(sdf.format(keyword.get("endTime")));
					
					predicate.add(builder.between(
							root.get("createdTimeAt"), startDate, endDate
							));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}//end for
		
		return predicate;
	}
	
}
