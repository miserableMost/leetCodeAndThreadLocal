package Test.October;

import java.util.Random;

class RandomizedSet {

    /**
     * Initialize your data structure here.
     */
    int initCap = 32;

    int cap = 0;

    Random random = new Random();

    static class Node {

        int val;
        Node next;
        int pos;
    }

    Node[] entrys;

    Node[] vals;
    int insert = 0;
    int count = 0;


    public RandomizedSet() {
        entrys = new Node[initCap];
        vals = new Node[initCap];
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified
     * element.
     */
    public boolean insert( int val ) {
        if (cap == initCap) {
            int newCap = initCap * 2;
            Node[] tmp = new Node[newCap];
            System.arraycopy(entrys, 0, tmp, 0, cap);
            for (int i = 0; i < initCap; i++) {
                Node nl = tmp[i];
                while (nl != null) {
                    if (nl.val > initCap || nl.val < -initCap) {
                        Node nm = tmp[i + initCap];
                        if (nm == null) {
                            tmp[i + initCap] = nl;
                        } else {
                            nm.next = nl;
                        }
                    }
                    nl = nl.next;
                }
            }
            initCap = newCap;
            entrys = tmp;

        }
        if (count == vals.length) {
            Node[] tmp = new Node[vals.length * 2];
            System.arraycopy(vals, 0, tmp, 0, vals.length);
            vals = tmp;
        }

        int hash = val & ( initCap - 1 );
        Node n = entrys[hash];
        if (null == n) {
            cap++;
            Node node = new Node();
            node.val = val;
            node.pos = insert;
            vals[insert] = node;
            insert++;
            count++;
            entrys[hash] = node;
            return true;
        } else {
            if (n.val == val) {
                return false;
            } else {
                Node tmp = n;
                while (tmp.next != null) {
                    if (tmp.next.val == val) {
                        return false;
                    }
                    tmp = tmp.next;
                }
                Node nl = new Node();
                vals[insert] = nl;
                nl.val = val;
                nl.pos = insert;
                tmp.next = nl;
                count++;
                insert++;

            }
        }
        return true;

    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove( int val ) {
        int hash = val & ( initCap - 1 );
        int pos = -1;
        boolean ok = false;
        Node n = entrys[hash];
        if (n != null) {
            if (n.val == val) {
                entrys[hash] = n.next;
                pos = n.pos;
                if (n.next == null) {
                    cap--;
                }
                ok = true;
            } else {
                while (n.next != null) {
                    if (n.next.val == val) {
                        n.next = n.next.next;
                        pos = n.pos;
                        ok = true;
                        break;
                    }
                    n = n.next;
                }
            }
            insert--;
        }
        for (int i = pos; i < insert && i != -1; i++) {
            vals[i + 1].pos--;
            vals[i] = vals[i + 1];
        }
        return ok;

    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index = random.nextInt(insert);
        return vals[index].val;
    }


}


