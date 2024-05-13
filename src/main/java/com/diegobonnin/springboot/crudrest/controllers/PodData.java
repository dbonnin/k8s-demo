package com.diegobonnin.springboot.crudrest.controllers;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PodData {

    private String ip;
    private String hostname;
    private String appVersion;
    private String timestamp;
    
}
