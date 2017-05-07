/**
 * Created by Administrator on 2017/5/6.
 */
var React = require('react');
import { Layout ,Menu ,Input, Row, Col,Icon ,Card ,Table,Button } from 'antd';
var Styles = require('../css/components/rank.css');
let SeparateLine = require('./separateLine.js');
import Img1 from '../img/img1.jpg';
import Img301 from '../img/301.png';
import Img302 from '../img/302.jpg';
import Carousel_2 from '../img/carousel_2.jpg';

var RankBlock = React.createClass({

    render : function () {
        return (
          <Layout className="rank">
              <SeparateLine title="音乐排行榜" subtitle="MUSIC RANKS" />
              <Row>
                  <Col span="16" offset="4">
                      <Row>
                          <Col span="12" className="block1">
                              <img src={Img1} alt=""/>
                              <div className="block1-title">
                                  <h1>巅峰榜</h1>
                                  <center><hr/></center>
                                  <h2>流行指数</h2>
                              </div>
                          </Col>
                          <Col span="6" className="block2">
                              <ul>
                                  <li>1  Selfish   - Virginia To Vegas</li>
                                  <li>2  Selfish   - Virginia To Vegas</li>
                                  <li>3  Selfish   - Virginia To Vegas</li>
                                  <li>4  Selfish   - Virginia To Vegas</li>
                                  <li>5  Selfish   - Virginia To Vegas</li>
                              </ul>
                          </Col>
                          <Col span="6" className="block3">
                              <img src={Img301} alt=""/>
                              <div className="block3-title">
                                  <h1>巅峰榜</h1>
                                  <center><hr/></center>
                                  <h2>欧美</h2>
                              </div>
                          </Col>
                      </Row>
                      <Row>
                          <Col span="6" className="block4">
                              <ul>
                                  <li>1  Selfish   - Virginia To Vegas</li>
                                  <li>2  Selfish   - Virginia To Vegas</li>
                                  <li>3  Selfish   - Virginia To Vegas</li>
                                  <li>4  Selfish   - Virginia To Vegas</li>
                                  <li>5  Selfish   - Virginia To Vegas</li>
                              </ul>
                          </Col>
                          <Col span="12">
                          </Col>
                          <Col span="6" className="block5">
                              <ul>
                                  <li>1  Selfish   - Virginia To Vegas</li>
                                  <li>2  Selfish   - Virginia To Vegas</li>
                                  <li>3  Selfish   - Virginia To Vegas</li>
                                  <li>4  Selfish   - Virginia To Vegas</li>
                                  <li>5  Selfish   - Virginia To Vegas</li>
                              </ul>
                          </Col>
                      </Row>
                      <Row>
                          <Col span="6" className="block1">
                              <img src={Img302} alt=""/>
                              <div className="block1-title">
                                  <h1>巅峰榜</h1>
                                  <center><hr/></center>
                                  <h2>民谣</h2>
                              </div>
                          </Col>
                          <Col span="6" className="block2">
                              <ul>
                                  <li>1  Selfish   - Virginia To Vegas</li>
                                  <li>2  Selfish   - Virginia To Vegas</li>
                                  <li>3  Selfish   - Virginia To Vegas</li>
                                  <li>4  Selfish   - Virginia To Vegas</li>
                                  <li>5  Selfish   - Virginia To Vegas</li>
                              </ul>
                          </Col>
                          <Col span="12" className="block3">
                              <img src={Carousel_2} alt=""/>
                              <div className="block3-title">
                                  <h1>巅峰榜</h1>
                                  <center><hr/></center>
                                  <h2>电子</h2>
                              </div>
                          </Col>
                      </Row>
                  </Col>
              </Row>
          </Layout>
        );
    }
});

module.exports = RankBlock;