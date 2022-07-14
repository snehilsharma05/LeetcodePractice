class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(rest-> rest[2] >= veganFriendly && rest[3] <= maxPrice && rest[4] <= maxDistance)
                .sorted((rest1,rest2) -> rest2[1] == rest1[1] ? rest2[0] - rest1[0] : rest2[1] - rest1[1])
                .map(rest -> rest[0])
                .collect(Collectors.toList());
    }
}