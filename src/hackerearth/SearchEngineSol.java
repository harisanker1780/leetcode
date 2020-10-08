package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SearchEngineSol {
	
	public static void main(String args[] ) throws Exception {
				
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();                // Reading input from STDIN
        int Q = Integer.parseInt(line);
        
        SearchEngine searchEngine = new SearchEngine();
        
        for(int i = 0; i < Q; i++) {
        	String[] str = br.readLine().split(" ");
        	int type = Integer.parseInt(str[0]);
        	
        	if(type == 1) {
        		String s = str[1];
        		searchEngine.addQuery(s);
        	} else if (type == 2) {
        		char c = str[1].charAt(0);
        		String[] suggessions = searchEngine.getSuggessions(c);
        		for(String sug : suggessions) {
        			System.out.print(sug + " ");
        		}
        		
        		System.out.println();
        	}
        }
    
    }
	
	static class SearchEngine {
		
		  Map<Character, QueryBukcet> map = new HashMap<>();
		  
		  public void addQuery(String str) {
			  char c = str.charAt(0);
			  if(!map.containsKey(c)) {
				  map.put(c, new QueryBukcet());
			  }
			  
			  QueryBukcet bucket = map.get(c);
			  bucket.addSearchString(str);
		  }
		  
		  public String[] getSuggessions(char c) {
			  QueryBukcet bucket = null;
			  if(map.containsKey(c)) {
				  bucket = map.get(c);
			  } else {
				  bucket = new QueryBukcet();
			  }
			  
			  return bucket.getSuggessions();
		  }
	}
	
	
	
	 static class QueryBukcet {
		  HashMap<String, SearchQuery> map = new HashMap<>();
		  PriorityQueue<SearchQuery> sugessions = new PriorityQueue<>();
		  
		  
		  public void addSearchString(String str) {
			  SearchQuery query;
			  if(map.containsKey(str)) {
				  query = map.get(str);
				  query.incrementCount();
			  } else {
				  query = new SearchQuery(str);
				  map.put(str, query);
			  }
			  
			  if(!sugessions.contains(query)) {
				  sugessions.add(query);
			  }
			  
			  getLastThree();
		  }
		  
		  public String[] getSuggessions() {
			  String[] sugessionsStr = new String[3];
			  ArrayList<SearchQuery> list = getLastThree();
			  for(int i = 0; i < 3; i++ ) {
				  if(list.size() > i) {
					  sugessionsStr[i] = list.get(i).query;
				  } else {
					  sugessionsStr[i] = "null";
				  }
			  }
			  
			  return sugessionsStr;
		  }
		  
		  private ArrayList<SearchQuery> getLastThree() {
			  ArrayList<SearchQuery> list = new ArrayList<SearchQuery>();
			  while(!sugessions.isEmpty() && list.size() < 3) {
				  list.add(sugessions.poll());
			  }
			  
			  sugessions.clear();
			  
			  for(SearchQuery q : list) {
				  sugessions.add(q);
			  }
			  
			  return list;
		  }
	  }
	
	   static class SearchQuery implements Comparable<SearchQuery> {
	        int count;
	        String query;

	        public SearchQuery(String query) {
	            this.query = query;
	            this.count = 1;
	        }

	        public void incrementCount() {
	            this.count++;
	        }

			@Override
			public int compareTo(SearchQuery other) {
				if(this.count < other.count) {
					return 1;
				} else if(this.count > other.count) {
					return -1;
				} else {
					return this.query.compareTo(other.query);
				}
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((query == null) ? 0 : query.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				SearchQuery other = (SearchQuery) obj;
				if (query == null) {
					if (other.query != null)
						return false;
				} else if (!query.equals(other.query))
					return false;
				return true;
			}
	    }	   
}
