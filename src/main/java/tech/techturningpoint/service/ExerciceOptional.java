package tech.techturningpoint.service;

import tech.techturningpoint.model.Artiste;
import tech.techturningpoint.model.Person;

import java.util.List;
import java.util.Optional;

/**
 * Exercices sur Optional de Java 8.
 */
public class ExerciceOptional implements IExerciceOptional {

    /**
     * Retourne le nom du premier artiste de la liste ipod de la personne s'il existe.
     * Indices : Utiliser map et filter.
     *
     * @param person personne
     * @return nom s'il existe, "unknown" sinon.
     */
    @Override
    public String getNameFirstArtisteInIpod(Person person) {
//        Optional<List<Artiste>> firstArtiste = Optional.of(person.dansMonIpod);
//        Optional firstArtiste = optionalPerson.map(Person::getDansMonIpod).get() .;
//        firstArtiste .map()

        Optional <Person> optionalPerson = Optional.ofNullable(person);
        String firstArtiste =
                optionalPerson.map(test -> test.dansMonIpod)
                        .filter(testList -> !testList.isEmpty())
                        .map(testList -> testList.get(0).nom)
                        .orElse("unknown") ;

//        System.out.println(firstArtiste);
        return firstArtiste;

//        sans optional
//        if (person != null && !person.dansMonIpod.isEmpty())
//            return person.dansMonIpod.get(0).nom;
//        return "unknown";
    }

    /**
     * Retourne le nom du chef s'il existe.
     * Indices : Utiliser map et flatMap.
     *
     * @param person le subordonné
     * @return nom du chef s'il existe, Eric sinon
     */
    @Override
    public String getNameOfChef(Person person) {
        //TODO
        Optional <Person> optionalPerson = Optional.ofNullable(person);
        String nameOfChief =
                optionalPerson.flatMap(test -> test.chef)
                        .map(test -> test.nom)
                        .orElse("Eric");
        return nameOfChief;

        //        sans optional
//        if (person != null && person.chef.isPresent())
//            return person.chef.map(test -> test.nom).toString();
//        return "unknown";
    }

}
