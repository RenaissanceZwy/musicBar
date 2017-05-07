/**
 * Created by Administrator on 2017/5/5.
 */
var React = require('react');
import { Carousel } from 'antd';
import carousel_1 from '../img/carousel-1.png';
import carousel_2 from '../img/carousel_2.jpg';
import carousel_3 from '../img/carousel_3.jpg';


var CarouselBar = React.createClass({
    render : function () {
        return (
            <Carousel autoplay>
                <div>
                    <img src={carousel_1} alt="" style={{width:'100%',height:'700px'}}/>
                </div>
                <div>
                    <img src={carousel_2} alt="" style={{width:'100%',height:'700px'}}/>
                </div>
                <div>
                    <img src={carousel_3} alt="" style={{width:'100%',height:'700px'}}/>
                </div>
            </Carousel>
        );
    }
});

module.exports = CarouselBar;