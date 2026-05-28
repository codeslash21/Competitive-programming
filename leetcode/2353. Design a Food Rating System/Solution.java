// https://leetcode.com/problems/design-a-food-rating-system/description/
class FoodRatings {
    Map<String, Integer> foodToRating;
    Map<String, String> foodToCuisine;
    Map<String, TreeSet<String>> cuisineToSet;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToRating=new HashMap<>();
        foodToCuisine=new HashMap<>();
        cuisineToSet=new HashMap<>();
        for(int i=0;i<foods.length;i++) {
            foodToRating.put(foods[i], ratings[i]);
            foodToCuisine.put(foods[i], cuisines[i]);
            cuisineToSet.computeIfAbsent(cuisines[i], k->new TreeSet<>((a,b)-> {
                int ratingA=foodToRating.get(a), ratingB=foodToRating.get(b);
                if(ratingA!=ratingB)    return ratingB-ratingA;
                return a.compareTo(b);
            })).add(foods[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine=foodToCuisine.get(food);
        TreeSet<String> set=cuisineToSet.get(cuisine);
        // remove the food from the set before changing the rating
        set.remove(food);
        foodToRating.put(food, newRating);
        // re-enter the food with updated rating
        set.add(food);
    }
    
    public String highestRated(String cuisine) {
        return cuisineToSet.get(cuisine).first();
    }
}
