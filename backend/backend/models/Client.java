package com.kata5.backend.model;

@Entity
@Table(name = "client")
public class Client {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
@Column(columnDefinition = "INT UNSIGNED")
private Long id;

@ManyToOne
    @JoinColumn(name = "id_plat", nullable = false)
    private Plat plat;
    
    @Column(nullable = false)
    private String name;
    
    @OneToOne(mappedBy = "commande")
    private Client client;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Plat getPlat() {
        return plat;
    }
    
    public void setPlat(Plat plat) {
        this.plat = plat;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
}







