class FoodRatings {

    // create map that maps cuisine to maps of ratings
    Map<String,TreeMap<Integer,TreeSet<String>>> cuisineToRatings;
    Map<String,Integer> foodToRating;
    Map<String,String> foodToCuisine;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineToRatings = new HashMap<>();
        foodToRating = new HashMap<>();
        foodToCuisine = new HashMap<>();
        for (int i=0; i < foods.length; i++) {
            foodToRating.put(foods[i], ratings[i]);
            foodToCuisine.put(foods[i], cuisines[i]);
            cuisineToRatings.computeIfAbsent(cuisines[i], k -> new TreeMap<>((r1, r2) ->                           Integer.compare(r2, r1)));
            cuisineToRatings.get(cuisines[i]).computeIfAbsent(ratings[i], k -> new TreeSet<>());
            cuisineToRatings.get(cuisines[i]).get(ratings[i]).add(foods[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        
        int curRating = foodToRating.get(food);
        String cuisine = foodToCuisine.get(food);

        cuisineToRatings.get(cuisine).get(curRating).remove(food);
        if (cuisineToRatings.get(cuisine).get(curRating).isEmpty()) {
            cuisineToRatings.get(cuisine).remove(curRating);
        }

        foodToRating.put(food, newRating);
        cuisineToRatings.get(cuisine).computeIfAbsent(newRating, k -> new TreeSet<>());
        cuisineToRatings.get(cuisine).get(newRating).add(food);

    }
    
    public String highestRated(String cuisine) {

        return cuisineToRatings.get(cuisine).firstEntry().getValue().first();
    }
}
