public class Checker {

    public static boolean checkLength(Object[] objects) {
        boolean flag = false;
        for (Object obj : objects) {
            if (obj == null) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static int getPosition(Object[] objects) {
        int position = 0;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                position = i;
                break;
            }
        }
        return position;
    }
}
