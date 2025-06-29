package com.admin.common.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.DecimalMax;
import java.math.BigDecimal;

@Data
public class TunnelDto {
    
    @NotBlank(message = "隧道名称不能为空")
    private String name;
    
    @NotNull(message = "入口节点不能为空")
    private Long inNodeId;
    
    @NotNull(message = "入口端口开始不能为空")
    @Min(value = 1, message = "入口端口开始必须大于0")
    @Max(value = 65535, message = "入口端口开始不能超过65535")
    private Integer inPortSta;
    
    @NotNull(message = "入口端口结束不能为空")
    @Min(value = 1, message = "入口端口结束必须大于0")
    @Max(value = 65535, message = "入口端口结束不能超过65535")
    private Integer inPortEnd;
    
    // 出口节点ID，当type=1时可以为空，会自动设置为入口节点ID
    private Long outNodeId;
    
    // 出口端口开始，当type=1时可以为空，会自动设置为入口端口
    @Min(value = 0, message = "出口端口开始必须大于等于1")
    @Max(value = 65535, message = "出口端口开始不能超过65535")
    private Integer outIpSta;
    
    // 出口端口结束，当type=1时可以为空，会自动设置为入口端口  
    @Min(value = 0, message = "出口端口结束必须大于等于1")
    @Max(value = 65535, message = "出口端口结束不能超过65535")
    private Integer outIpEnd;
    
    @NotNull(message = "隧道类型不能为空")
    private Integer type;
    
    @NotNull(message = "流量计算类型不能为空")
    private Integer flow;
    
    // 流量倍率，默认为1.0
    @DecimalMin(value = "0.0", message = "流量倍率不能小于0.0")
    @DecimalMax(value = "100.0", message = "流量倍率不能大于100.0")
    private BigDecimal trafficRatio = new BigDecimal("1.0");
    
    // 协议类型（隧道转发时使用：tls、tcp、mtls），默认为tls
    private String protocol;
    
    // TCP监听地址，默认为0.0.0.0
    private String tcpListenAddr = "0.0.0.0";
    
    // UDP监听地址，默认为0.0.0.0
    private String udpListenAddr = "0.0.0.0";
} 