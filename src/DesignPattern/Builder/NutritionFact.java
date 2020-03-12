package DesignPattern.Builder;

public class NutritionFact {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    private  final int transFat;
    private final int protein;
    private final int energy;

    private NutritionFact(NutritionBuilder nutritionBuilder){
        servingSize = nutritionBuilder.servingSize;
        servings = nutritionBuilder.servings;
        fat = nutritionBuilder.fat;
        sodium = nutritionBuilder.sodium;
        calories = nutritionBuilder.calories;
        carbohydrate = nutritionBuilder.carbohydrate;
        transFat = nutritionBuilder.transFat;
        protein = nutritionBuilder.protein;
        energy = nutritionBuilder.energy;
    }

    public static class NutritionBuilder {

        private final int servingSize;
        private final int servings;
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;
        private int transFat;
        private int protein;
        private int energy;

        public NutritionBuilder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public NutritionBuilder calories(int val){
            calories = val;
            return this;
        }

        public NutritionBuilder fat(int val){
            fat = val;
            return this;
        }

        public NutritionBuilder sodium(int val){
            sodium = val;
            return this;
        }

        public NutritionBuilder carbohydrate(int val){
            carbohydrate = val;
            return this;
        }

        public NutritionBuilder transFat(int val){
            transFat = val;
            return this;
        }

        public NutritionBuilder protein(int val){
            protein = val;
            return this;
        }

        public NutritionBuilder energy(int val){
            energy = val;
            return this;
        }

        public NutritionFact build(){
            return new NutritionFact(this);
        }
    }

    public static void main(String[] args) {
        NutritionFact coke = new NutritionBuilder(250,8).calories(100).carbohydrate(60).energy(115).transFat(60).fat(26).build();
        System.out.println("Nutrition fact of coke is :" +coke);
    }
}
