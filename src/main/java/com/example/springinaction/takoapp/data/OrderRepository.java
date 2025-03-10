package com.example.springinaction.takoapp.data;

import com.example.springinaction.takoapp.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder order);


}
