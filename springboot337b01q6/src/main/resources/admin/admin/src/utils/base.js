const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot337b01q6/",
            name: "springboot337b01q6",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot337b01q6/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "微信小程序民宿预订管理系统设计与实现"
        } 
    }
}
export default base
