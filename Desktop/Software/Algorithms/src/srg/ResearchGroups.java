package srg;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ResearchGroups {

	public static class MemberProperties {
		public boolean existence = false;
		public int groupNumber;
		public boolean groupLeader = false;
		public String name;
	}
	
	public static void printMemberInfo(MemberProperties m){
		if(m.name == null) return;
		System.out.print("Member: " + m.name + " exists and belongs to group " + m.groupNumber + ". " + m.name );
		if(m.groupLeader){
			System.out.println(" is a group leader!");
		} else {
			System.out.println(" is not a group leader!");
		}
	}
	
	public static String[][] sortGroups(String[][] groups){
		System.out.println();
		String[][] sortedGroups = new String[groups.length][];
		int[] k = new int[groups.length];
		for(int i=0; i<groups.length; i++){	
			k[i] = groups[i].length;
		}
		
		HeapSort myHeap1 = new HeapSort(k);
		myHeap1.sort();
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < k.length; i++){
			set.add(k[i]);
		}
		int v=0, w=0;
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			int kl = it.next();
			for(int j=0; j<groups.length; j++){
				if(kl == groups[j].length){
					sortedGroups[v] = new String[groups[j].length];
					for(int i = 0; i<groups[j].length; i++){ 
						sortedGroups[v][w] = groups[j][i];	
						w++;
					}
					w=0;
					v++;					
				}
			}
		}
		
		return sortedGroups;		
	}
	
	
	
	public static void print(String[][] string){
		System.out.println("\n");

		for(String[] str: string){
			for(String x : str){
				System.out.print(x + " ");
			}
			System.out.println("\n");
		}
	}
	
	public static void searchMember(String[][] groups, String member){
		
		boolean valid = false;
		for(int i = 0; i < groups.length; i++){
			MemberProperties mp = new MemberProperties();
			for(int j = 0; j < groups[i].length; j++){
				if(groups[i][j].equals(member)){
					valid = true;
					mp.existence = true;
					mp.groupNumber = i;
					if(j==0) mp.groupLeader = true;
					mp.name = member;
				}
			}
			printMemberInfo(mp);
		}
		if(!valid){
			System.out.println("Member: " + member + " does not exist.");
		}
	}
	
	
    public static void main(String[] args) {
        String[][] groups = { {"Bob", "Carol", "Eric", "Matt"},             // 0
                              {"Jim", "Lucy", "Terry", "Brenda", "Ben"},    // 1
                              {"Susan", "Brad", "Jim"},                     // 2
                              {"Sue", "Wendy", "Sam"},                      // 3
                              {"Kate", "Jack", "James", "Sydney"},          // 4
                              {"Mohammad", "Tim", "Kian"},                  // 5
                              {"Emma", "Carol"},                            // 6
                              {"Nick", "Osama", "Harry", "Ben"},            // 7
                              {"Mary", "John", "Ricky"} };                  // 8

        // TODO: Run your searching and sorting methods here.
        searchMember(groups, "Bob");
        searchMember(groups, "Jimbo");
        searchMember(groups, "Ricky");
        searchMember(groups, "Harry");

        print(groups);
        print(sortGroups(groups));
        /*
        for (int i=0;i<groups.length;i++) {
            System.out.print("group " + i + ": ");
            for (int j = 0; j < groups[i].length; j++)
                System.out.print(groups[i][j] + " ");
            System.out.println();
        }*/
    }

}