package src.pubsub;

import java.util.*;

/**
 * Created by bishalgautam on 5/30/17.
 */
public class Pubsub{

    static class Publisher{

        public Publisher(){

        }

        public void send(Message message, PubSubServer myserver){
             myserver.queue.add(message);

        }
    }

    static class Subscriber{

        public Subscriber(){

        }

        public List<String> topics = new ArrayList<>(2);
        public Queue<Message> myMessage = new LinkedList<>();

        public void listen(String topic){
            topics.add(topic);
        }

        public void print(){
            for(int i=0 ; i < topics.size(); i++){
                while(!myMessage.isEmpty()){
                    Message newMessage  = myMessage.remove();
                    System.out.println("Topic: " + newMessage.topic + "\n" + newMessage.payload);
                }
            }
        }

    }

    static class Message{

        public Message(){

        }

        public String topic;
        public String payload;

    }

    static class PubSubServer{

        public PubSubServer(){

        }

        public Queue<Message> queue = new LinkedList<Message>();

        public List<Subscriber> subscribers = new ArrayList<>();

        public void forward(){
                while (!queue.isEmpty()){
                    Message currMessage = queue.remove();

                    for(Subscriber subscriber : subscribers){

                        for(int j = 0; j < subscriber.topics.size() ; j++){

                            if(currMessage.topic.equalsIgnoreCase(subscriber.topics.get(j))){
                                subscriber.myMessage.add(currMessage);
                            }
                        }
                    }
                }

        }
    }


    public static  void main(String[] args){

        Publisher dogPublisher = new Publisher();
        Publisher catPublisher = new Publisher();

        Subscriber animalLover = new Subscriber();
        Subscriber oldCatlady  = new Subscriber();

        PubSubServer server = new PubSubServer();

        Message dogMessage = new Message();
        dogMessage.topic = "Dogs";
        dogMessage.payload = "People hate dogs";

        Message catMessage = new Message();
        catMessage.topic = "Cats";
        catMessage.payload = "Cats are cruel sometimes";

        dogPublisher.send(dogMessage,server );
        catPublisher.send(catMessage,server);

        animalLover.listen("Dogs");
        animalLover.listen("Cats");

        oldCatlady.listen("Cats");

        server.subscribers.add(animalLover);
        server.subscribers.add(oldCatlady);

        server.forward();

        System.out.println("Animallover has subscribed to following");
        animalLover.print();

        System.out.println("OldCatlady has subscribed to following");
        oldCatlady.print();


    }
}
