package Arslan.Ch03StackandQueues.Q3_06_Animal_Shelter;


public class TestSol {


    public static void main(String[] args) {
        Solution.AnimalQueue animals= new Solution.AnimalQueue();


        animals.enqueue(new Solution.Cat("c1"));
        animals.enqueue(new Solution.Cat("c2"));
        animals.enqueue(new Solution.Dog("d1"));
        animals.enqueue(new Solution.Dog("d2"));
        animals.enqueue(new Solution.Cat("c3"));
        animals.enqueue(new Solution.Dog("d3"));
        animals.enqueue(new Solution.Dog("d4"));
        animals.enqueue(new Solution.Cat("c4"));



        System.out.println(animals.dequeueAny());
        System.out.println(animals.dequeueDog());
        System.out.println(animals.dequeueCat());

        animals.enqueue(new Solution.Dog("d5"));
        animals.enqueue(new Solution.Cat("c4"));

        System.out.println(animals.dequeueAny());
        System.out.println(animals.dequeueDog());
        System.out.println(animals.dequeueCat());
    }

}
