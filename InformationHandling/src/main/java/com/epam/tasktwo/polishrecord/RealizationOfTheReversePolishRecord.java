package com.epam.tasktwo.polishrecord;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class RealizationOfTheReversePolishRecord {

    private final static RealizationOfTheReversePolishRecord INSTANCE = new RealizationOfTheReversePolishRecord();
    private final static String NUMBER_REGEX = "\\d+";


    private RealizationOfTheReversePolishRecord() {
    }

    public static RealizationOfTheReversePolishRecord getInstance() {
        return INSTANCE;
    }

    private static boolean checkPriority(Operator stackOperation, Operator currentOperation) {
        return (stackOperation.getPriority() < currentOperation.getPriority() && stackOperation != Operator.OPEN_BRACKET);
    }


    public static List<String> toPolishRecord(List<String> partsOfExpression) {
        List<String> polishExpression = new ArrayList<>();
        ArrayDeque<Operator> stack = new ArrayDeque<>();

        for (String partOfExpression : partsOfExpression) {
            if (partOfExpression.matches(NUMBER_REGEX)) {
                polishExpression.add(partOfExpression);
            } else {
                switch (partOfExpression) {
                    case "(":
                        stack.push(Operator.OPEN_BRACKET);
                        break;
                    case ")":
                        while (stack.peek() != Operator.OPEN_BRACKET) {
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.pop();
                        break;
                    case "<<":
                        while (checkPriority(stack.peek(), Operator.DOUBLE_LEFT_SHIFT)) {
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(Operator.DOUBLE_LEFT_SHIFT);
                        break;
                    case ">>":
                        while (!stack.isEmpty() && checkPriority(stack.peek(), Operator.DOUBLE_RIGHT_SHIFT)) {
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(Operator.DOUBLE_RIGHT_SHIFT);
                        break;
                    case "&":
                        while (!stack.isEmpty() && checkPriority(stack.peek(), Operator.AND)) {
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(Operator.AND);
                        break;
                    case "^":
                        while (!stack.isEmpty() && checkPriority(stack.peek(), Operator.CAP)) {
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(Operator.CAP);
                        break;
                    case "|":
                        while (!stack.isEmpty() && checkPriority(stack.peek(), Operator.OR)) {
                            polishExpression.add(stack.pop().getValue());
                        }
                        stack.push(Operator.OR);
                        break;
                }
            }
        }
        while (!stack.isEmpty()) {
            polishExpression.add(stack.pop().getValue());
        }
        return polishExpression;
    }


}
