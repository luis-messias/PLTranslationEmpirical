package com.example;
public static String Strongest_Extension(String className, List<String> extensions) {

  int[] strengths = new int[extensions.size()];

  for (int i = 0; i < extensions.size(); i++) {
    char upperCaseCount = 0;
    char lowerCaseCount = 0;

    for (char ch : extensions.get(i).toCharArray()) {
      if (Character.isUpperCase(ch)) upperCaseCount++;
      else if (Character.isLowerCase(ch)) lowerCaseCount++;

    }

    strengths[i] = upperCaseCount - lowerCaseCount;
  }


  int maxStrengthIndex = 0;

  for (int i = 1; i < extensions.size(); i++) {

    if (strengths[maxStrengthIndex] < strengths[i]) {
      maxStrengthIndex = i;
    }
  }

  return className + "." + extensions.get(maxStrengthIndex);

}