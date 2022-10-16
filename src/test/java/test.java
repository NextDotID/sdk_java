import kvservice.KVClient;

public class test {
    public static void main(String []args){
        KVClient client = (KVClient) KVClient.getDevClient();
    }
}
