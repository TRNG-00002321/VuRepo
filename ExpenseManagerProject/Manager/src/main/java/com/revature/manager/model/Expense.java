package com.revature.manager.model;

public class Expense {
    private int expenseId;
    private int userId;
    private double amount;
    private String description;
    private String date;
    private String status;
    private int reviewerId;
    private String comment;
    private String reviewDate;

    public Expense() {
    }

    public Expense(int expenseId, int userId, double amount, String description, String date, String status, int reviewerId, String comment, String reviewDate) {
        this.expenseId = expenseId;
        this.userId = userId;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.status = status;
        this.reviewerId = reviewerId;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", userId=" + userId +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", reviewerId=" + reviewerId +
                ", comment='" + comment + '\'' +
                ", reviewDate='" + reviewDate + '\'' +
                '}';
    }

    public int getExpenseId() {
        return expenseId;
    }

    public int getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public int getReviewerId() {
        return reviewerId;
    }

    public String getComment() {
        return comment;
    }

    public String getReviewDate() {
        return reviewDate;
    }
}
