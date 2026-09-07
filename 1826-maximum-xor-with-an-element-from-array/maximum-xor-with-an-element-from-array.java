class Node {
    Node[] links = new Node[2];
    
    Node() {}

    boolean containsKey(int bit) {
        return links[bit] != null;
    }

    Node get(int bit) {
        return links[bit];
    }

    void put(int bit, Node node) {
        links[bit] = node;
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node node = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    int getMaxXOR(int num) {
        Node node = root;
        int maxi = 0;
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(node.containsKey(1 - bit)) {
                maxi = maxi | (1 << i);
                node = node.get(1 - bit);
            }
            else {
                node  = node.get(bit);
            }
        }
        return maxi;
    }
}

class Query {
    int xi;
    int mi;
    int query;
    Query(int xi, int mi, int query) {
        this.xi = xi;
        this.mi = mi;
        this.query = query;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        ArrayList<Query> ql = new ArrayList<>();

        for(int i = 0; i < queries.length; i++) {
            ql.add(new Query(queries[i][0], queries[i][1], i));
        }
        ql.sort((a,b) -> Integer.compare(a.mi, b.mi));

        Arrays.sort(nums);

        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);

        Trie trie = new Trie();
        int j = 0;
        for(int i = 0; i < queries.length; i++) {
            int xi = ql.get(i).xi;
            int mi = ql.get(i).mi;
            for(; j < nums.length; j++) {
                if(nums[j] <= mi) {
                    trie.insert(nums[j]);
                }
                else {
                    break;
                }
            }
            int query = ql.get(i).query;
            if(j > 0) {
                ans[query] = Math.max(ans[query], trie.getMaxXOR(xi)); 
            }
        }
        return ans;
    }
}