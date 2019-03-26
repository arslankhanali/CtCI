package Arslan.Ch03StackandQueues.Q3_06_Animal_Shelter;

import java.util.LinkedList;

public class Solution {


    public static abstract class Animal{
        String name;
        int order;

        public Animal(String name) {
            this.name = name;
        }

        public void setOrder(int i){
            this.order=i;
        }

        public int getOrder(){
            return order;
        }
    }


    public static class Dog extends Animal {

        public Dog(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Dog "+name;
        }
    }

    public static class Cat extends Animal {

        public Cat(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Cat "+name;
        }
    }



    public static class AnimalQueue{
        LinkedList<Dog> dogs = new LinkedList<Dog>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        private int order = 0;


        public void enqueue(Animal animal){
            if(animal instanceof Dog){
                dogs.addLast((Dog) animal);
                animal.setOrder(order);
            }
            else if(animal instanceof Cat){
                cats.addLast((Cat) animal);
                animal.setOrder(order);
            }
            order++;
        }

        public Animal dequeueAny(){
            if(dogs.peekLast().getOrder()>cats.peekLast().getOrder()){
                return dogs.removeLast();
            }
            else return cats.removeLast();

        }
        public Animal dequeueDog(){
            return dogs.removeLast();
        }
        public Animal dequeueCat(){
            return cats.removeLast();
        }

        public int size(){
            return dogs.size()+cats.size();
        }
    }




}
