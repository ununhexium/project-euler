public class P028NumberSpiralDiagonals
{
    public static void main(String[] args)
    {
        long total = 1;
        long layers = 500;
        for (int layer = 1; layer <= layers; ++layer)
        {
            for (int side = 0; side < 4; ++side)
            {
                long q = getQuantity(layer, side, 2 * layer);
//                System.out.println(q);
                total += q;
            }
        }
        System.out.println(total);
    }
    
    /**
     * http://projecteuler.net/problem=28
     * 
     * @param layer
     *            the ring (0=central value), value must be >=1
     * @param side
     *            the side (0 1 2 3),
     * @param position
     *            the position of the number on the side
     * @return the value of the indicated cell
     */
    private static long getQuantity(long layer, long side, long position)
    {
        if (layer > 0)
        {
            return getLayerLength(layer) * side + position + getQuantity(layer - 1, 3, (layer-1) * 2);
        }
        return 1;
    }
    
    /**
     * @param layer
     *            >=1
     * @return The length of a side of the indicated layer
     */
    private static long getLayerLength(long layer)
    {
        /**
         * 1 -> 2; 2 -> 4; 3 -> 6; 4 -> 8;
         */
        return layer * 2;
    }
}
