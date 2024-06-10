package org.example.casestudymodule4.specication;

import org.example.casestudymodule4.model.Player;
import org.springframework.data.jpa.domain.Specification;

public class PlayerSpecification {
    public static Specification<Player> hasName(String name){
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }
    public static Specification<Player> hasSalary(Double salary) {
        return (root, query, criteriaBuilder) -> {
            if (salary == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("salary"), salary);
        };
    }
}
