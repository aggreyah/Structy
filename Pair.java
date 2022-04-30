public class Pair <Q, R> {
    private Q key;
    private R value;
    Pair(Q key, R value){
        this.key = key;
        this.value = value;
    }

    public Q getKey() {
        return key;
    }

    public R getValue() {
        return value;
    }
}
