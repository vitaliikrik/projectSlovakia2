package com.vsemvs.project_slovakia2.service.good.interfaces;

import com.vsemvs.project_slovakia2.model.Good;

import java.util.List;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  IGoodService
  @version  1.0.0 
  @since 7/19/2021 - 19.01
*/
public interface IGoodService {
    List<Good> getAll();
    Good get(String id);
    Good create(Good Good);
    Good update(Good Good);
    Good delete(String id);
}
