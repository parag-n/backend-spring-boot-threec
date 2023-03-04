package com.threec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threec.beans.Bid;

public interface BidDao extends JpaRepository<Bid, Integer>{

}
