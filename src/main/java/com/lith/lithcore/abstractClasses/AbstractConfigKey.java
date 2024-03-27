package com.lith.lithcore.abstractClasses;

public abstract class AbstractConfigKey {
    protected static String setKey(String key) {
        return calculatePath() + key;
    }

    private static String calculatePath() {
        StringBuilder path = new StringBuilder();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        Class<?> extendingClass = null;
        for (int i = 1; i < stackTrace.length; i++) {
            String className = stackTrace[i].getClassName();

            try {
                Class<?> clazz = Class.forName(className);

                if (AbstractConfigKey.class.isAssignableFrom(clazz) && !AbstractConfigKey.class.equals(clazz)) {
                    extendingClass = clazz;
                    break;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (extendingClass != null) {
            Class<?> currentClass = extendingClass;

            while (currentClass != null && AbstractConfigKey.class.isAssignableFrom(currentClass)) {
                path.insert(0, currentClass.getSimpleName().toLowerCase() + ".");
                currentClass = currentClass.getEnclosingClass();
            }
        }

        return path.toString();
    }
}
