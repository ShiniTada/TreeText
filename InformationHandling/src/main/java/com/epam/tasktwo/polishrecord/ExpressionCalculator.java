package com.epam.tasktwo.polishrecord;

import com.epam.tasktwo.interpretion.Context;
import com.epam.tasktwo.interpretion.MathExpression;
import com.epam.tasktwo.interpretion.impl.*;

import java.util.ArrayList;
import java.util.List;


public class ExpressionCalculator {

    private final static ExpressionCalculator INSTANCE = new ExpressionCalculator();


    private ExpressionCalculator() {
    }


    public static ExpressionCalculator getInstance() {
        return INSTANCE;
    }


    public Integer calculateExpression(List<String> expression) {
        List<String> polishExpression = RealizationOfTheReversePolishRecord.toPolishRecord(expression);
        List<MathExpression> listMathExpressions = toMathExpressionList(polishExpression);
        Context context = new Context();
        for (MathExpression mathPartExpression : listMathExpressions) {
            mathPartExpression.interpret(context);
        }
        return context.popValue();
    }


    private List<MathExpression> toMathExpressionList(List<String> polishExpression) {
        List<MathExpression> listExpression = new ArrayList<>();
        for (String partOfPolishExpression : polishExpression) {
            switch (partOfPolishExpression) {
                case "|":
                    listExpression.add(new OrExpression());
                    break;
                case "&":
                    listExpression.add(new AndExpression());
                    break;
                case "^":
                    listExpression.add(new CapExpression());
                    break;
                case "<<":
                    listExpression.add(new DoubleLeftShiftExpression());
                    break;
                case ">>":
                    listExpression.add(new DoubleRightShiftExpression());
                    break;
                default:
                    int value = Integer.parseInt(partOfPolishExpression);
                    listExpression.add(new NumberExpression(value));
                    break;
            }
        }
        return listExpression;
    }
}
