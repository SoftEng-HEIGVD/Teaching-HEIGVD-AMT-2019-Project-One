package ch.heigvd.amt.projectone.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Map;


@Builder
@Getter
@EqualsAndHashCode
public class Order {

    private int id;
    private int idClient;
//    private Map<Integer,Integer> command;       // key : idProduct , value : quantity
    private String command;

//    public Order(int id, int idClient, Map<Integer,Integer> command){
//        this.id=id;
//        this.idClient=idClient;
//        this.command=command;
//    }

    public Order(int id, int idClient, String command){
        this.id=id;
        this.idClient=idClient;
        this.command=command;
    }
}
