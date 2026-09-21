class RandomizedCollection {

    HashMap<Integer, Integer> map;

    ArrayList<Integer> list = new ArrayList<>();

    public RandomizedCollection() {

        map = new HashMap<>();
    }

    public boolean insert(int val) {

        if (map.containsKey(val) && map.get(val) > 0) {

            map.put(val, map.get(val) + 1);

            list.add(val);

            return false;
        }

        map.put(val, 1);

        list.add(val);

        return true;

    }

    public boolean remove(int val) {

        if (map.containsKey(val) && map.get(val) > 0) {

            map.put(val, map.get(val) - 1);

            list.remove(Integer.valueOf(val));

            return true;
        }

        return false;
    }

    public int getRandom() {

        int index = (int) (Math.random() * list.size());

        return list.get(index);

    }

}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */