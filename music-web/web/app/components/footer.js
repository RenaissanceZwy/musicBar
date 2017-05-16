/**
 * Created by Administrator on 2017/5/4.
 */
var React = require('react');
import { Layout ,Menu ,Input, Row, Col,Icon  } from 'antd';
const { Header, Footer, Sider, Content } = Layout;
var Styles = require('../css/components/footer.css');
import twitter from '../img/twitter.png';
import twitterB from '../img/twitter-b.png';
import facebook from '../img/facebook.png';
import facebookB from '../img/facebook-b.png';
import instagram from '../img/instagram.png';
import instagramB from '../img/instagram-b.png';
import qqmusic from '../img/qqmusic.png';
import qqmusicB from '../img/qqmusic-b.png';
import wangyiyun from '../img/wangyiyun.png';
import wangyiyunB from '../img/wangyiyun-b.png';
import xiami from '../img/xiami.png';
import xiamiB from '../img/xiami-b.png';
var imgs = [twitter,instagram,facebook,wangyiyun,qqmusic,xiami];
var imgsB = [twitterB,instagramB,facebookB,wangyiyunB,qqmusicB,xiamiB];

var FootBar = React.createClass({
    handleMouseOver:function (event) {
        var hr;
        if(event.target.getAttribute("data")=="Contact"){
             hr = this.refs.contact;
        }else {
             hr = this.refs.renaissance;
        }
        var width = hr.style.width;
        hr.style.width = width.replace(/[^0-9]/ig,"")*2+"px";
    },
    handleMouseOut:function (event) {
        var hr;
        if(event.target.getAttribute("data")=="Contact"){
            hr = this.refs.contact;
        }else {
            hr = this.refs.renaissance;
        }
        var width = hr.style.width;
        hr.style.width = width.replace(/[^0-9]/ig,"")/2+"px";
    },
    handelImgMouseOver:function (event) {
        var index = event.target.getAttribute("data-idx");
        event.target.src = imgsB[index];
    },
    handleImgMouseOut:function (event) {
        var index = event.target.getAttribute("data-idx");
        event.target.src = imgs[index];
    },
    render : function () {
        return (
            <div>
                <Layout>
                    <Footer className="footer">
                        <Row>
                            <Col span="8" offset="8">
                                <h1>Contact Us</h1>
                                <a href="#" data="Contact" onMouseOver={this.handleMouseOver} onMouseOut={this.handleMouseOut}>
                                    联系我们
                                </a>
                                <center> <hr style={{width:'20px'}} ref="contact"/></center>
                            </Col>
                        </Row>
                        <Row>
                            <Col span="8">
                                <h3>友情推荐</h3>
                                <ul>
                                    <li>
                                        <a href="#">
                                            <img src={imgs[0]} data-idx="0" alt="twitter" onMouseOver={this.handelImgMouseOver} onMouseOut={this.handleImgMouseOut} />
                                            <p>twitter</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <img src={imgs[1]} data-idx="1" alt="instagram" onMouseOver={this.handelImgMouseOver} onMouseOut={this.handleImgMouseOut} />
                                            <p>instagram</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <img src={imgs[2]} data-idx="2" alt="facebook" onMouseOver={this.handelImgMouseOver} onMouseOut={this.handleImgMouseOut} />
                                            <p>facebook</p>
                                        </a>
                                    </li>
                                </ul>
                            </Col>
                            <Col span="8">
                                <a href="#" data="Renaissance" onMouseOver={this.handleMouseOver} onMouseOut={this.handleMouseOut}>
                                    <h1>Renaissance</h1>
                                </a>
                                <center>
                                    <hr style={{width:'40px'}} ref="renaissance"/>
                                </center>
                                <h3>武汉理工大学计算机科学与技术学院软件工程软件zy1301</h3>
                                <h3>create by 赵文奕</h3>
                            </Col>
                            <Col span="8">
                                <h3>合作链接</h3>
                                <ul>
                                    <li>
                                        <a href="http://music.163.com/">
                                            <img src={imgs[3]} data-idx="3" alt="网易云音乐" onMouseOver={this.handelImgMouseOver} onMouseOut={this.handleImgMouseOut} />
                                            <p>网易云音乐</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="https://y.qq.com/">
                                            <img src={imgs[4]} data-idx="4" alt="qq音乐" onMouseOver={this.handelImgMouseOver} onMouseOut={this.handleImgMouseOut}  />
                                            <p>QQ音乐</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="http://www.xiami.com/">
                                            <img src={imgs[5]} data-idx="5" alt="虾米音乐" onMouseOver={this.handelImgMouseOver} onMouseOut={this.handleImgMouseOut} />
                                            <p>虾米音乐</p>
                                        </a>
                                    </li>
                                </ul>
                            </Col>
                        </Row>
                    </Footer>
                </Layout>
            </div>
        );
    }
});

module.exports = FootBar;