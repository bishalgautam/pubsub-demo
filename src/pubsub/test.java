//package pubsub;
//
//import pubsub.Pubsub.Publisher;
//import pubsub.Pubsub.Subscriber;
//import pubsub.Pubsub.Message;
//import pubsub.Pubsub.PubSubServer;
//
//
//
///**
// * Created by bishalgautam on 5/30/17.
// */
//public class test{
//
//    public static  void main(String[] args){
//
//        Publisher dogPublisher = new Publisher();
//        Publisher catPublisher = new Publisher();
//
//        Subscriber animalLover = new Subscriber();
//        Subscriber oldCatlady  = new Subscriber();
//
//        PubSubServer server = new PubSubServer();
//
//        Message dogMessage = new Message();
//        dogMessage.topic = "Dogs";
//        dogMessage.payload = "People hate dogs";
//
//        Message catMessage = new Message();
//        catMessage.topic = "Cats";
//        catMessage.payload = "Cats are cruel sometimes";
//
//        dogPublisher.send(dogMessage,server );
//        catPublisher.send(catMessage,server);
//
//        animalLover.listen("Dogs");
//        animalLover.listen("Cats");
//
//        oldCatlady.listen("Cats");
//
//        server.subscribers.add(animalLover);
//        server.subscribers.add(oldCatlady);
//
//        server.forward();
//
//        System.out.println("Animallover has subscribed to following");
//        animalLover.print();
//
//        System.out.println("OldCatlady has subscribed to following");
//        oldCatlady.print();
//
//
//
//
//    }
//}
