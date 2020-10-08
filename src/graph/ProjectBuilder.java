package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Build Order: You are given list of projects and a list of dependencies(which is the list of pairs of projects, where the second project is dependent on the 
 * first project). All of a project's dependencies must be built before the project is. Find a build order that will allow the projects to be built. If there is
 * no valid build order, return an error.
 * 
 * EXAMPLE
 * 
 * Input:
 *  projects: a, b, c, d, e, f
 *  dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 *  
 * Output: f, e, a, b, d, c
 * 
 *
 */
public class ProjectBuilder {
	
	List<Project> projects = new ArrayList<>();
	
	public ProjectBuilder(String[] names, String[][] dependencies) {
		for(String name : names) {
			Project p = new Project(name);
			projects.add(p);
		}
		
		for(String[] dep : dependencies) {
			Project first = projects.stream().filter(p -> p.name.equals(dep[0])).collect(Collectors.toList()).get(0);
			Project second = projects.stream().filter(p -> p.name.equals(dep[1])).collect(Collectors.toList()).get(0);
			second.dependencies.add(first);
		}
	}
	
	public List<String> build() throws CircularDependencyException {
		
		List<String> result = new ArrayList<>();
		
		for(Project p : projects) {
			if(p.buildStatus == BuildStatus.NO_BUILD) {
				build(p, result);
			}
		}
		
		return result;
	}
	
	private void build(Project p, List<String> result) throws CircularDependencyException {
		
		if(p.buildStatus == BuildStatus.BUILD_COMPLETE)
			return;
		
		if(p.buildStatus == BuildStatus.IN_PROGRESS)
			throw new CircularDependencyException();
		
		p.buildStatus = BuildStatus.IN_PROGRESS;
		for(Project dep : p.dependencies) {
			build(dep, result);
		}
		
		result.add(p.name);
		p.buildStatus = BuildStatus.BUILD_COMPLETE;
	}
	
	
	public static void main(String[] args) {
		String[] names = {"a", "b", "c", "d", "e", "f"};
		String[][] deps = {
				{"a", "d"},
				{"f", "b"},
				{"b", "d"},
				{"f", "a"},
				{"d", "c"}
		};
		
		ProjectBuilder sol = new ProjectBuilder(names, deps);
		try {
			List<String> result = sol.build();
			System.out.println(Arrays.toString(result.toArray()));
		} catch (CircularDependencyException e) {
			e.printStackTrace();
		}
	}
}

class Project {
	
	public BuildStatus buildStatus = BuildStatus.NO_BUILD;
	
	public List<Project> dependencies;
	
	public String name;
	
	public Project(String name) {
		this.name = name;
		this.dependencies = new ArrayList<>();
	}
}

class CircularDependencyException extends Exception {
	
}

enum BuildStatus {
	NO_BUILD,
	IN_PROGRESS,
	BUILD_COMPLETE
}
