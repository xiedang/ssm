package com.xiedang.www.controller;

import com.xiedang.www.bo.ProblemBo;
import com.xiedang.www.service.ProblemService;
import com.xiedang.www.vo.ProblemVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Mr.zyk
 * @Description: ${description}
 * @Date: 2018/12/22 20:06
 */
@Controller
@RequestMapping("/problem")
public class ProblemController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProblemService problemService;

    /**
     * @Author: Mr.zyk
     * @Description: 根据id查询单条数据
     * @param: [request, id]
     * @Return: com.xiedang.www.bo.ProblemBo
     * @Date: 2018/12/23 13:53
     */
    @RequestMapping("/queryById")
    @ResponseBody
    public ProblemBo queryById(HttpServletRequest request,Integer id){
        log.info("根据id单条查询,参数{}", id);
        return problemService.selectById(id);
    }

    /**
     * @Author: Mr.zyk
     * @Description: 分页查询
     * @param: [request, pageSize, currentPage]
     * @Return: java.util.List<com.xiedang.www.bo.ProblemBo>
     * @Date: 2018/12/22 20:24
     */
    @RequestMapping("/queryAllByPage")
    @ResponseBody
    public List<ProblemBo> queryAllByPage(HttpServletRequest request, int pageSize, int currentPage){
        log.info("分页查询,参数{}", pageSize,currentPage);
        Map<String,Object> map = new HashMap<>();
        int start = (currentPage-1)*pageSize;
        map.put("start",start);
        map.put("pageSize",pageSize);
        List<ProblemBo> problemBos = new ArrayList<>();
        try {
            problemBos = problemService.queryAllByPage(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return problemBos;
    }

    /**
     * @Author: Mr.zyk
     * @Description: 条件查询
     * @param: [request, problemVo]
     * @Return: java.util.List<com.xiedang.www.bo.ProblemBo>
     * @Date: 2018/12/22 20:26
     */
    @RequestMapping("/queryProblem")
    @ResponseBody
    public List<ProblemBo> queryProblem(HttpServletRequest request, ProblemVo problemVo){
        log.info("条件查询,参数{}",problemVo);
        List<ProblemBo> problemBos = new ArrayList<>();
        try {
            problemBos = problemService.query(problemVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return problemBos;
    }

    /**
     * @Author: Mr.zyk
     * @Description: 新增
     * @param: [request, problemVo]
     * @Return: int
     * @Date: 2018/12/22 20:29
     */
    @RequestMapping("/addProblem")
    @ResponseBody
    public int addProblem(HttpServletRequest request, ProblemVo problemVo){
        log.info("新增，参数{}",problemVo);
        int i = 0;
        try {
            i = problemService.addProblem(problemVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * @Author: Mr.zyk
     * @Description: 修改
     * @param: [request, problemVo]
     * @Return: int
     * @Date: 2018/12/22 20:35
     */
    @RequestMapping("/updateProblem")
    @ResponseBody
    public int updateProblem(HttpServletRequest request,ProblemVo problemVo){
        log.info("修改，参数{}",problemVo);
        int i = 0;
        try {
            i = problemService.updateProblem(problemVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * @Author: Mr.zyk
     * @Description: 批量删除
     * @param: [request, str]
     * @Return: int
     * @Date: 2018/12/22 20:38
     */
    @RequestMapping("/deleteProblem")
    @ResponseBody
    public int deleteProblem(HttpServletRequest request,String str){
        log.info("删除，参数{}",str);
        int i = 0;
        String[] s = str.split(",");
        try {
            i = problemService.deleteProblem(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
