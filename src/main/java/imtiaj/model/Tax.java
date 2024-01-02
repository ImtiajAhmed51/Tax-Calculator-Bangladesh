package imtiaj.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tax")
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    @Column(name = "totalIncome")
    private double totalIncome;

    @Column(name = "taxAmount")
    private double taxAmount;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public User getUser() {
        return user;
    }

    public Tax(int id, double totalIncome, double taxAmount, User user) {
        this.id = id;
        this.totalIncome = totalIncome;
        this.taxAmount = taxAmount;
        this.user = user;
    }

    public Tax() {
    }

    public void setUser(User user) {
        this.user = user;
    }
}
