package com.amaker.bean;

public class Calcutor {
	
	private int firstNumber;
	private int secondNumber;
	private String operate;
	private double result;
	public int getFirstNumber() {
		return firstNumber;
	}
	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}
	public int getSecondNumber() {
		return secondNumber;
	}
	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	public double getResult() {
		System.out.println("getResult running .........");
		if(operate != null){
			if(operate.equals("+")){
				result = firstNumber + secondNumber;
			}else if(operate.equals("-")){
				result = firstNumber - secondNumber;
			}else if(operate.equals("*")){
				result = firstNumber * secondNumber;
			}else if(operate.equals("/")){
				result = firstNumber / secondNumber;
			}else{
				result = 0;
			}
		}
		System.out.println(firstNumber);
		System.out.println(operate);
		System.out.println(secondNumber);
		System.out.println("=");
		System.out.println(result);
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
}
