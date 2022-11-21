package tech.techturningpoint.service;


import tech.techturningpoint.model.Artiste;
import tech.techturningpoint.model.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Exercices sur les Streams Java 8.
 *
 * http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 * http://soat.developpez.com/tutoriels/java/projet-lambda-java8/
 * https://www.techempower.com/blog/2013/03/26/everything-about-java-8/
 * http://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
 */
public class ExerciceStream implements IExerciceStream {

    /**
     * Ordonner par âge croissant et extraire le nom.
     * Indices : sorted() et Comparator.???
     *
     * @param persons Liste de personnes
     * @return Liste de noms
     */
    @Override
    public List<String> getNamesSortedByAge(final List<Person> persons) {
        //TODO
       return persons.stream()
                .sorted(
                        Comparator.comparing(p -> p.getAge())
                )
                .map(p -> p.nom)
               .collect(Collectors.toList()) ;

    }

    /**
     * Ordonner par âge croissant et concaténer les noms pour affichage avec séparateur, préfixe et suffixe.
     * Indices : Collectors.joining()
     *
     * @param persons Liste de personnes
     * @return "Du plus jeune au plus âgé: <Liste de noms séparés par une virgule>".
     */
    @Override
    public String displayNamesFromYoungestToOldest(final List<Person> persons) {
        //TODO
         return persons.stream()
                 .sorted(
                         Comparator.comparing(p -> p.getAge())
                 )
                 .map(p -> p.nom)
                .collect(Collectors.joining(", ", "Du plus jeune au plus âgé: ", "."));

    }

    /**
     * Faire une moyenne des âges.
     * @param persons Liste de personnes
     * @return moyenne des âges
     */
    @Override
    public double averageAge(final List<Person> persons) {
        //TODO
<<<<<<< HEAD
        return persons.stream()
                .collect(Collectors.averagingInt(p -> p.getAge()));
=======
//       System.out.println(persons.stream()
//               .collect(Collectors.averagingDouble(p -> p.getAge())));
        return persons.stream()
                .collect(Collectors.averagingInt(p -> p.getAge()))
                ;
//
//        System.out.println(persons.stream()
//                .mapToInt(p -> p.getAge())
//                .average()
//                .getAsDouble() );
//        return persons.stream()
//                .mapToInt(p -> p.getAge())
//                .average()
//                .getAsDouble() ;
>>>>>>> 90c9d96c4fa449ce387bd2b6a2c1d9b303f7e97d
    }

    /**
     * Faire une moyenne des âges des hommes.
     * @param persons Liste de personnes
     * @return moyenne des âges
     */
    @Override
    public double averageAgeMale(final List<Person> persons) {
        //TODO
        return persons.stream()
                .filter(p -> p.sexe == "M" || p.sexe.toLowerCase() == "homme")
<<<<<<< HEAD
                .collect(Collectors.averagingDouble(p -> p.getAge()));
    }
=======
          .collect(Collectors.averagingDouble(p -> p.getAge()));

//        double average = persons
//            .stream()
//            .filter(p -> p.sexe == "M" || p.sexe.toLowerCase() == "homme")
//            .mapToInt(Person::getAge)
//            .average()
//            .getAsDouble();
//        return average;
}
>>>>>>> 90c9d96c4fa449ce387bd2b6a2c1d9b303f7e97d

    /**
     * Faire une moyenne des âges des personnes dont le nom commence par une lettre.
     * @param persons Liste de personnes
     * @param letter initiale
     * @return moyenne des âges
     */
    @Override
    public double averageAgeByInitial(final List<Person> persons, final String letter) {
        //TODO
        return persons.stream()
                .filter(p -> p.nom.startsWith(letter) )
                .collect(Collectors.averagingDouble(p -> p.getAge()));
    }

    /**
     * Faire une moyenne des âges en fonction du sexe.
     * Indices : Collectors.groupingBy, Collectors.averagingInt
     * @param persons Liste de personnes
     * @return Map avec la moyenne d'âge en fonction du sexe
     */
    @Override
    public Map<String, Double> averageAgeBySex(final List<Person> persons) {
        //TODO
         Map<String, Double> mapAverageAgeBySex = persons.stream()
                .collect(
                        Collectors.groupingBy(
                                p -> p.sexe,
                                Collectors.averagingInt(Person::getAge)));
        return mapAverageAgeBySex;
    }


    /**
     * Retourner la liste, classée par ordre alphabétique, de personnes qui écoutent un artiste très populaire.
     * Implémentation en Java 8 de la méthode {@link IExerciceStream#getMainstreamMusicListeners}
     * @param persons Liste de personnes
     * @return liste de personnes qui écoutent un artiste très populaire
     */
    @Override
    public List<Person> getMainstreamMusicListenersJava8(final List<Person> persons){
        //TODO
<<<<<<< HEAD
=======
//        List<Person> listeners = new ArrayList<>();
//        for (Person person : persons) {
//            boolean isBestSeller = false;
//            for (Artiste a : person.dansMonIpod) {
//                if (a.classement <= 10) {
//                    isBestSeller = true;
//                    break;
//                }
//            }
//            if (isBestSeller)
//                listeners.add(person);
//        }
//        Collections.sort(listeners, new Comparator<Person>() {
//            public int compare(Person a1, Person a2) {
//                return a1.nom.compareTo(a2.nom);
//            }
//        });
//        return listeners;



//        System.out.println(persons.stream()
//                .filter(p -> !p.dansMonIpod.isEmpty() )
//                .filter(person -> {
//                    return person.dansMonIpod.stream()
//                            .anyMatch(artiste -> artiste.classement <= 10) ;
//                } )
//                .sorted(
//                        (a,b) -> {return a.nom.compareTo(b.nom);}
//                )
//                .collect(Collectors.toList()));

>>>>>>> 90c9d96c4fa449ce387bd2b6a2c1d9b303f7e97d
        return persons.stream()
                .filter(p -> !p.dansMonIpod.isEmpty() )//pas obliger car ??? (complete)
                .filter(person -> {
                    return person.dansMonIpod.stream()
                            .anyMatch(artiste -> artiste.classement <= 10) ;
                } )
                .sorted(
                        Comparator.comparing(p -> p.nom)
                )
                .collect(Collectors.toList());
    }
}
