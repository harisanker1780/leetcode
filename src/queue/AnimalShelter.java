package queue;

import java.util.HashMap;
import java.util.Map;

/**
 * An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis. People must adopt either the oldest(based on the arrival)
 * all the animals at the shelter. or they can select whether they would prefer a dog or a cat(and receive the oldest animal of that type). They cannot select the 
 * which specific animal they would like. Create the data structures to maintain this system and implement operations such as enqueue. dequeueAny, dequeueDog, and 
 * dequeueCat. You may use built-in LinkedList data structure. 
 *
 */
public class AnimalShelter {
	
	private Map<String, Animal> animals = new HashMap<>();
	private Animal head;
	private Animal tail;
	
	public void enqueue(Animal animal) {
		if(animals.containsKey(animal.type)) {
			Animal list = animals.get(animal.type);
			list.typeEnd.typeNext = animal;
			list.typeEnd = animal;
			tail.next = animal;
			animal.prev = tail;
			tail = animal;
		} else {
			animal.typeEnd = animal;
			animals.put(animal.type, animal);
			if(head == null) {
				head = animal;
			} 
			
			if(tail == null) {
				tail = animal;
			} else {
				tail.next = animal;
				animal.prev = tail;
				tail = animal;
			}
		}
	}
	
	public Animal dequeueAny() {
		if(head == null)
			return null;
		
		Animal animal = head;
		removeAnimal(animal);
		return animal;
	}
	
	public Cat dequeueCat() {
		if(!animals.containsKey("Cat"))
			return null;
		
		Animal cat = animals.get("Cat");
		removeAnimal(cat);
		return (Cat)cat;
		
	}
	
	public Dog dequeueDog() {
		if(!animals.containsKey("Dog"))
			return null;
		
		Animal dog = animals.get("Dog");
		removeAnimal(dog);
		return (Dog)dog;
	}
	
	private void removeAnimal(Animal animal) {
		if(animal == head) {
			head = head.next;
		}
		
		if(animal == tail) {
			tail = tail.prev;
		}
		
		if(animal.prev != null) {
			animal.prev.next = animal.next;
			animal.prev = null;
			animal.next = null;
		}
		
		if(animal.typeNext == null) {
			animals.remove(animal.type);
		} else {
			animal.typeNext.typeEnd = animal.typeEnd;
			animals.put(animal.type, animal.typeNext);
		}
	}

	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter();
		shelter.enqueue(new Dog("D1"));
		shelter.enqueue(new Dog("D2"));
		shelter.enqueue(new Cat("C1"));
		shelter.enqueue(new Cat("C2"));
		shelter.enqueue(new Cat("C3"));
		shelter.enqueue(new Dog("D3"));
		shelter.enqueue(new Cat("C4"));
		
		System.out.println(shelter.dequeueAny());
		System.out.println(shelter.dequeueAny());
		System.out.println(shelter.dequeueAny());
		System.out.println(shelter.dequeueAny());
		System.out.println(shelter.dequeueAny());
		System.out.println(shelter.dequeueAny());
		System.out.println(shelter.dequeueAny());
		
		shelter.enqueue(new Dog("D4"));
		shelter.enqueue(new Dog("D5"));
		shelter.enqueue(new Cat("C5"));
		
		System.out.println(shelter.dequeueCat());
		System.out.println(shelter.dequeueAny());
		System.out.println(shelter.dequeueAny());
	}
}

class Animal {
	
	public String name;
	public String type;
	
	public Animal next;
	public Animal prev;
	public Animal typeNext;
	public Animal typeEnd;
	
	public Animal(String name, String type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", type=" + type + "]";
	}
}

class Dog extends Animal{
	public Dog(String name) {
		super(name, "Dog");
	}
}

class Cat extends Animal {
	public Cat(String name) {
		super(name, "Cat");
	}
}
