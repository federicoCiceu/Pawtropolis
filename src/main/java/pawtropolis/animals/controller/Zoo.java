package pawtropolis.animals.controller;

import pawtropolis.animals.*;

import java.util.*;

public class Zoo {

    private final Map<Class<? extends Animal>, List<Animal>> animalMap;

    public Zoo() {
        this.animalMap = new HashMap<>();
    }

    public void putAnimal(Animal animal) {
        if (!animalMap.containsKey(animal.getClass())) {
            animalMap.put(animal.getClass(), new ArrayList<>());
        }
        animalMap.get(animal.getClass()).add(animal);
    }

    public <T extends Animal> Optional<Animal> getTallestAnimal(Class<T> animalSpecies) {
        return animalMap
                .get(animalSpecies)
                .stream()
                .max(Comparator.comparingDouble(Animal::getHeight));

    }

    public <T extends Animal> Optional<Animal> getLowestAnimal(Class<T> animalSpecies) {
        return animalMap
                .get(animalSpecies)
                .stream()
                .min(Comparator.comparingDouble(Animal::getHeight));
    }

    public <T extends Animal> Optional<Animal> getHeaviestAnimal(Class<T> animalSpecies) {
        return animalMap
                .get(animalSpecies)
                .stream()
                .max(Comparator.comparingDouble(Animal::getWeight));
    }

    public <T extends Animal> Optional<Animal> getLightestAnimal(Class<T> animalSpecies) {
        return animalMap
                .get(animalSpecies)
                .stream()
                .min(Comparator.comparingDouble(Animal::getWeight));
    }

    public Optional<Animal> getLongestTailedAnimal() {
        return animalMap
                .values()
                .stream()
                .flatMap(List::stream)
                .filter(TailedAnimal.class::isInstance)
                .max(Comparator.comparingDouble(animal -> ((TailedAnimal) animal).getTailLength()));
    }

    public Optional<Animal> getWidestWingspan() {
        return animalMap
                .values()
                .stream()
                .flatMap(List::stream)
                .filter(WingedAnimal.class::isInstance)
                .max(Comparator.comparingDouble(animal -> ((WingedAnimal) animal).getWingspan()));
    }

}




