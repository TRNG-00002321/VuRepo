package com.revature.JavaAssignment;
import com.revature.JavaAssignment.MainClass;
import com.revature.JavaAssignment.ControlStatement;

public class MainClass {
    public static void main(String[] args) {
        AddSubMulDiv addSubMulDiv = new AddSubMulDiv();
        int a = 6;
        int b = 2;
        addSubMulDiv.add(a,b);
        addSubMulDiv.sub(a,b);
        addSubMulDiv.multiply(a,b);
        addSubMulDiv.divide(a,b);
        ControlStatement controlStatement = new ControlStatement();
        controlStatement.controlStatement(5);
        controlStatement.shortCircuit(4,6,2);
        controlStatement.outPutComputation();
    }
}
