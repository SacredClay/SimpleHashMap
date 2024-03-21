public class MyHashMap<K, V>
{
    private final int DEFAULT_SIZE = 5;

    private Entry<K, V>[] hashMap;

    public MyHashMap()
    {
        this.hashMap = new Entry[DEFAULT_SIZE];
    }

    private int createHash(K key)
    {
        return key.hashCode()%(hashMap.length);
    }

    public void put(K key, V value)
    {
        int hashKey = createHash(key);
        Entry<K, V> traversal = this.hashMap[hashKey];

        if(traversal == null)
        {
            this.hashMap[hashKey] = new Entry<>(key, value);
            return;
        }

        while (traversal.getNext() != null)
        {
            if (traversal.getKey() == key)
            {
                traversal.updateValue(value);
                return;
            }
            traversal = traversal.getNext();
        }

        if (traversal.getKey() == key)
        {
            traversal.updateValue(value);
            return;
        }

        traversal.setNext(new Entry<>(key, value));
    }

    public V get(K key)
    {
        int hashKey = createHash(key);
        Entry<K, V> traversal = this.hashMap[hashKey];

        while (traversal.getKey() != null)
        {
            if (traversal.getKey() == key)
            {
                return traversal.getValue();
            }

            traversal.getNext();
        }

        return null;
    }

    public Entry remove(K key)
    {
        int hashKey = createHash(key);
        Entry<K, V> traversal = this.hashMap[hashKey];

        if (traversal == null)
        {
            return null;
        }

        if (traversal.getKey() == key)
        {
            this.hashMap[hashKey] = traversal.getNext();
            traversal.setNext(null);
            return traversal;
        }

        Entry<K, V> previous = traversal;
        traversal = traversal.getNext();

        while (traversal != null)
        {
            if (traversal.getKey() == key)
            {
                previous.setNext(traversal.getNext());
                traversal.setNext(null);
                return traversal;
            }
            traversal = traversal.getNext();
            previous = previous.getNext();
        }

        return null;
    }

    public int size()
    {
        int size = 0;
        for (Entry e : hashMap)
        {
            while (e != null)
            {
                e = e.getNext();
                size++;
            }
        }

        return size;
    }

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();

        for (Entry e : hashMap)
        {
            while (e != null)
            {
                output.append(e.toString());
                if (e.getNext() != null)
                    output.append(" -> ");

                e = e.getNext();
            }
            output.append("\n");
        }

        output.append("---------------------\n");

        return output.toString();
    }
}
