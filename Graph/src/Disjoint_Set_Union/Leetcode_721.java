package Disjoint_Set_Union;


import java.util.*;

public class Leetcode_721 {
    public static void main(String[] args) {
        Leetcode_721 app = new Leetcode_721();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John","johnsmith@mail.com","john00@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary","mary@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John","johnnybravo@mail.com")));
        System.out.println("Merged accounts : " + app.accountsMerge(accounts));
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();    DisjointSet dsu = new DisjointSet(accounts.size());
        Map<String,Integer> emailToNameId = new HashMap<>();
        for (int i = 0; i < n; i++) { //update parents to join
            for (int j = 1; j < accounts.get(i).size(); j++) {//for all emails. first is name.
                String email = accounts.get(i).get(j);//i th account's jth email
                int newNameId = i;
                if (emailToNameId.containsKey(email)){
                    int existingNameId = emailToNameId.get(email);
                    dsu.union(existingNameId,newNameId);
                }
                else emailToNameId.put(email,newNameId);
            }
        }

        Map<Integer,TreeSet<String>> nameIdToEmails = new HashMap<>(); //do the join
        for (int i = 0; i < n; i++) {
            int parent = dsu.find(i);
            List<String> emails = accounts.get(i);
            nameIdToEmails.putIfAbsent(parent,new TreeSet<>());
            nameIdToEmails.get(parent).addAll(emails.subList(1,emails.size())); //add all emails, 0'th is name
        }

        List<List<String>> mergedAccounts = new ArrayList<>(); //compile results
        for (int nameId : nameIdToEmails.keySet()) {
            String name = accounts .get(nameId).get(0);
            List<String> emails = new ArrayList<>();    emails.add(name);
            emails.addAll(nameIdToEmails.get(nameId));

            mergedAccounts.add(emails);
        }
        return mergedAccounts;
    }
    class DisjointSet{
        private int[] parent,rank;

        public DisjointSet(int n) {
            parent = new int[n];    for (int i = 0; i < n; i++) parent[i] = i; //assign self as parent
            rank = new int[n];
        }
        public int find(int x){
            if (parent[x]==x) return x;//group leader found
            return find(parent[x]);
        }
        public void union(int x,int y){
            int px = find(x),py = find(y);
            if (px==py) return;//already in same group

            if(rank[px]>rank[py])   parent[py] = px;//make the high rank parent
            else if (rank[py]>rank[px]) parent[px] = py;
            else { parent[py] = px; rank[px]++; }
        }
    }
}