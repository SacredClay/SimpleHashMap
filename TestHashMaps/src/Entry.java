public class Entry<K,V>
{
    private final K key;

    private V value;

    private Entry<K, V> next;

    public Entry(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public K getKey()
    {
        return this.key;
    }

    public V getValue()
    {
        return this.value;
    }

    public void updateValue(V value)
    {
        this.value = value;
    }

    public Entry getNext()
    {
        return this.next;
    }

    public void setNext(Entry<K, V> entry)
    {
        this.next = entry;
    }

    @Override
    public String toString()
    {
        return key.toString() + " " + value.toString();
    }
}
