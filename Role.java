package my.smvc.hib.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role implements Comparable<Role>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long role_id;
	private String role;
	
	@Override
	public int compareTo(Role o) {	
		return this.role.compareTo(o.role);
	}
}
