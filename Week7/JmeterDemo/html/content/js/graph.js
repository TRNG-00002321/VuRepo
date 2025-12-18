/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
$(document).ready(function() {

    $(".click-title").mouseenter( function(    e){
        e.preventDefault();
        this.style.cursor="pointer";
    });
    $(".click-title").mousedown( function(event){
        event.preventDefault();
    });

    // Ugly code while this script is shared among several pages
    try{
        refreshHitsPerSecond(true);
    } catch(e){}
    try{
        refreshResponseTimeOverTime(true);
    } catch(e){}
    try{
        refreshResponseTimePercentiles();
    } catch(e){}
});


var responseTimePercentilesInfos = {
        data: {"result": {"minY": 42.0, "minX": 0.0, "maxY": 547.0, "series": [{"data": [[0.0, 42.0], [0.1, 43.0], [0.2, 43.0], [0.3, 43.0], [0.4, 43.0], [0.5, 43.0], [0.6, 43.0], [0.7, 43.0], [0.8, 44.0], [0.9, 44.0], [1.0, 44.0], [1.1, 44.0], [1.2, 44.0], [1.3, 44.0], [1.4, 44.0], [1.5, 44.0], [1.6, 44.0], [1.7, 44.0], [1.8, 44.0], [1.9, 44.0], [2.0, 44.0], [2.1, 44.0], [2.2, 44.0], [2.3, 44.0], [2.4, 44.0], [2.5, 44.0], [2.6, 44.0], [2.7, 44.0], [2.8, 44.0], [2.9, 44.0], [3.0, 44.0], [3.1, 44.0], [3.2, 44.0], [3.3, 44.0], [3.4, 44.0], [3.5, 44.0], [3.6, 44.0], [3.7, 44.0], [3.8, 44.0], [3.9, 44.0], [4.0, 44.0], [4.1, 44.0], [4.2, 44.0], [4.3, 45.0], [4.4, 45.0], [4.5, 45.0], [4.6, 45.0], [4.7, 45.0], [4.8, 45.0], [4.9, 45.0], [5.0, 45.0], [5.1, 45.0], [5.2, 45.0], [5.3, 45.0], [5.4, 45.0], [5.5, 45.0], [5.6, 45.0], [5.7, 45.0], [5.8, 45.0], [5.9, 45.0], [6.0, 45.0], [6.1, 45.0], [6.2, 45.0], [6.3, 45.0], [6.4, 45.0], [6.5, 45.0], [6.6, 45.0], [6.7, 45.0], [6.8, 45.0], [6.9, 45.0], [7.0, 45.0], [7.1, 45.0], [7.2, 45.0], [7.3, 45.0], [7.4, 45.0], [7.5, 45.0], [7.6, 45.0], [7.7, 45.0], [7.8, 45.0], [7.9, 45.0], [8.0, 45.0], [8.1, 45.0], [8.2, 45.0], [8.3, 45.0], [8.4, 45.0], [8.5, 45.0], [8.6, 45.0], [8.7, 45.0], [8.8, 45.0], [8.9, 45.0], [9.0, 45.0], [9.1, 45.0], [9.2, 45.0], [9.3, 45.0], [9.4, 45.0], [9.5, 45.0], [9.6, 45.0], [9.7, 45.0], [9.8, 45.0], [9.9, 45.0], [10.0, 45.0], [10.1, 45.0], [10.2, 45.0], [10.3, 45.0], [10.4, 45.0], [10.5, 45.0], [10.6, 45.0], [10.7, 45.0], [10.8, 45.0], [10.9, 45.0], [11.0, 45.0], [11.1, 45.0], [11.2, 45.0], [11.3, 45.0], [11.4, 45.0], [11.5, 45.0], [11.6, 45.0], [11.7, 45.0], [11.8, 45.0], [11.9, 45.0], [12.0, 45.0], [12.1, 45.0], [12.2, 45.0], [12.3, 45.0], [12.4, 45.0], [12.5, 45.0], [12.6, 45.0], [12.7, 45.0], [12.8, 45.0], [12.9, 46.0], [13.0, 46.0], [13.1, 46.0], [13.2, 46.0], [13.3, 46.0], [13.4, 46.0], [13.5, 46.0], [13.6, 46.0], [13.7, 46.0], [13.8, 46.0], [13.9, 46.0], [14.0, 46.0], [14.1, 46.0], [14.2, 46.0], [14.3, 46.0], [14.4, 46.0], [14.5, 46.0], [14.6, 46.0], [14.7, 46.0], [14.8, 46.0], [14.9, 46.0], [15.0, 46.0], [15.1, 46.0], [15.2, 46.0], [15.3, 46.0], [15.4, 46.0], [15.5, 46.0], [15.6, 46.0], [15.7, 46.0], [15.8, 46.0], [15.9, 46.0], [16.0, 46.0], [16.1, 46.0], [16.2, 46.0], [16.3, 46.0], [16.4, 46.0], [16.5, 46.0], [16.6, 46.0], [16.7, 46.0], [16.8, 46.0], [16.9, 46.0], [17.0, 46.0], [17.1, 46.0], [17.2, 46.0], [17.3, 46.0], [17.4, 46.0], [17.5, 46.0], [17.6, 46.0], [17.7, 46.0], [17.8, 46.0], [17.9, 46.0], [18.0, 46.0], [18.1, 46.0], [18.2, 46.0], [18.3, 46.0], [18.4, 46.0], [18.5, 46.0], [18.6, 46.0], [18.7, 46.0], [18.8, 46.0], [18.9, 46.0], [19.0, 46.0], [19.1, 46.0], [19.2, 46.0], [19.3, 46.0], [19.4, 46.0], [19.5, 46.0], [19.6, 46.0], [19.7, 46.0], [19.8, 46.0], [19.9, 46.0], [20.0, 46.0], [20.1, 46.0], [20.2, 46.0], [20.3, 46.0], [20.4, 46.0], [20.5, 46.0], [20.6, 46.0], [20.7, 46.0], [20.8, 46.0], [20.9, 46.0], [21.0, 46.0], [21.1, 46.0], [21.2, 46.0], [21.3, 46.0], [21.4, 46.0], [21.5, 46.0], [21.6, 46.0], [21.7, 46.0], [21.8, 46.0], [21.9, 46.0], [22.0, 46.0], [22.1, 46.0], [22.2, 46.0], [22.3, 46.0], [22.4, 46.0], [22.5, 46.0], [22.6, 46.0], [22.7, 46.0], [22.8, 46.0], [22.9, 46.0], [23.0, 46.0], [23.1, 46.0], [23.2, 46.0], [23.3, 46.0], [23.4, 46.0], [23.5, 46.0], [23.6, 46.0], [23.7, 46.0], [23.8, 46.0], [23.9, 46.0], [24.0, 46.0], [24.1, 46.0], [24.2, 46.0], [24.3, 46.0], [24.4, 46.0], [24.5, 46.0], [24.6, 46.0], [24.7, 46.0], [24.8, 46.0], [24.9, 46.0], [25.0, 46.0], [25.1, 46.0], [25.2, 46.0], [25.3, 46.0], [25.4, 46.0], [25.5, 46.0], [25.6, 46.0], [25.7, 46.0], [25.8, 46.0], [25.9, 46.0], [26.0, 46.0], [26.1, 46.0], [26.2, 46.0], [26.3, 46.0], [26.4, 46.0], [26.5, 46.0], [26.6, 46.0], [26.7, 46.0], [26.8, 46.0], [26.9, 46.0], [27.0, 46.0], [27.1, 46.0], [27.2, 46.0], [27.3, 46.0], [27.4, 46.0], [27.5, 46.0], [27.6, 46.0], [27.7, 46.0], [27.8, 46.0], [27.9, 46.0], [28.0, 46.0], [28.1, 46.0], [28.2, 46.0], [28.3, 46.0], [28.4, 46.0], [28.5, 46.0], [28.6, 46.0], [28.7, 46.0], [28.8, 46.0], [28.9, 46.0], [29.0, 46.0], [29.1, 46.0], [29.2, 46.0], [29.3, 46.0], [29.4, 46.0], [29.5, 46.0], [29.6, 46.0], [29.7, 46.0], [29.8, 47.0], [29.9, 47.0], [30.0, 47.0], [30.1, 47.0], [30.2, 47.0], [30.3, 47.0], [30.4, 47.0], [30.5, 47.0], [30.6, 47.0], [30.7, 47.0], [30.8, 47.0], [30.9, 47.0], [31.0, 47.0], [31.1, 47.0], [31.2, 47.0], [31.3, 47.0], [31.4, 47.0], [31.5, 47.0], [31.6, 47.0], [31.7, 47.0], [31.8, 47.0], [31.9, 47.0], [32.0, 47.0], [32.1, 47.0], [32.2, 47.0], [32.3, 47.0], [32.4, 47.0], [32.5, 47.0], [32.6, 47.0], [32.7, 47.0], [32.8, 47.0], [32.9, 47.0], [33.0, 47.0], [33.1, 47.0], [33.2, 47.0], [33.3, 47.0], [33.4, 47.0], [33.5, 47.0], [33.6, 47.0], [33.7, 47.0], [33.8, 47.0], [33.9, 47.0], [34.0, 47.0], [34.1, 47.0], [34.2, 47.0], [34.3, 47.0], [34.4, 47.0], [34.5, 47.0], [34.6, 47.0], [34.7, 47.0], [34.8, 47.0], [34.9, 47.0], [35.0, 47.0], [35.1, 47.0], [35.2, 47.0], [35.3, 47.0], [35.4, 47.0], [35.5, 47.0], [35.6, 47.0], [35.7, 47.0], [35.8, 47.0], [35.9, 47.0], [36.0, 47.0], [36.1, 47.0], [36.2, 47.0], [36.3, 47.0], [36.4, 47.0], [36.5, 47.0], [36.6, 47.0], [36.7, 47.0], [36.8, 47.0], [36.9, 47.0], [37.0, 47.0], [37.1, 47.0], [37.2, 47.0], [37.3, 47.0], [37.4, 47.0], [37.5, 47.0], [37.6, 47.0], [37.7, 47.0], [37.8, 47.0], [37.9, 47.0], [38.0, 47.0], [38.1, 47.0], [38.2, 47.0], [38.3, 47.0], [38.4, 47.0], [38.5, 47.0], [38.6, 47.0], [38.7, 47.0], [38.8, 47.0], [38.9, 47.0], [39.0, 47.0], [39.1, 47.0], [39.2, 47.0], [39.3, 47.0], [39.4, 47.0], [39.5, 47.0], [39.6, 47.0], [39.7, 47.0], [39.8, 47.0], [39.9, 47.0], [40.0, 47.0], [40.1, 47.0], [40.2, 47.0], [40.3, 47.0], [40.4, 47.0], [40.5, 47.0], [40.6, 47.0], [40.7, 47.0], [40.8, 47.0], [40.9, 47.0], [41.0, 47.0], [41.1, 47.0], [41.2, 47.0], [41.3, 47.0], [41.4, 47.0], [41.5, 47.0], [41.6, 47.0], [41.7, 47.0], [41.8, 47.0], [41.9, 47.0], [42.0, 47.0], [42.1, 47.0], [42.2, 47.0], [42.3, 47.0], [42.4, 47.0], [42.5, 47.0], [42.6, 47.0], [42.7, 47.0], [42.8, 47.0], [42.9, 47.0], [43.0, 47.0], [43.1, 47.0], [43.2, 47.0], [43.3, 47.0], [43.4, 47.0], [43.5, 47.0], [43.6, 47.0], [43.7, 47.0], [43.8, 47.0], [43.9, 47.0], [44.0, 47.0], [44.1, 47.0], [44.2, 47.0], [44.3, 47.0], [44.4, 47.0], [44.5, 47.0], [44.6, 47.0], [44.7, 47.0], [44.8, 47.0], [44.9, 47.0], [45.0, 47.0], [45.1, 47.0], [45.2, 48.0], [45.3, 48.0], [45.4, 48.0], [45.5, 48.0], [45.6, 48.0], [45.7, 48.0], [45.8, 48.0], [45.9, 48.0], [46.0, 48.0], [46.1, 48.0], [46.2, 48.0], [46.3, 48.0], [46.4, 48.0], [46.5, 48.0], [46.6, 48.0], [46.7, 48.0], [46.8, 48.0], [46.9, 48.0], [47.0, 48.0], [47.1, 48.0], [47.2, 48.0], [47.3, 48.0], [47.4, 48.0], [47.5, 48.0], [47.6, 48.0], [47.7, 48.0], [47.8, 48.0], [47.9, 48.0], [48.0, 48.0], [48.1, 48.0], [48.2, 48.0], [48.3, 48.0], [48.4, 48.0], [48.5, 48.0], [48.6, 48.0], [48.7, 48.0], [48.8, 48.0], [48.9, 48.0], [49.0, 48.0], [49.1, 48.0], [49.2, 48.0], [49.3, 48.0], [49.4, 48.0], [49.5, 48.0], [49.6, 48.0], [49.7, 48.0], [49.8, 48.0], [49.9, 48.0], [50.0, 48.0], [50.1, 48.0], [50.2, 48.0], [50.3, 48.0], [50.4, 48.0], [50.5, 48.0], [50.6, 48.0], [50.7, 48.0], [50.8, 48.0], [50.9, 48.0], [51.0, 48.0], [51.1, 48.0], [51.2, 48.0], [51.3, 48.0], [51.4, 48.0], [51.5, 48.0], [51.6, 48.0], [51.7, 48.0], [51.8, 48.0], [51.9, 48.0], [52.0, 48.0], [52.1, 48.0], [52.2, 48.0], [52.3, 48.0], [52.4, 48.0], [52.5, 48.0], [52.6, 48.0], [52.7, 48.0], [52.8, 48.0], [52.9, 48.0], [53.0, 48.0], [53.1, 48.0], [53.2, 48.0], [53.3, 48.0], [53.4, 49.0], [53.5, 49.0], [53.6, 49.0], [53.7, 49.0], [53.8, 49.0], [53.9, 49.0], [54.0, 49.0], [54.1, 49.0], [54.2, 49.0], [54.3, 49.0], [54.4, 49.0], [54.5, 49.0], [54.6, 49.0], [54.7, 49.0], [54.8, 49.0], [54.9, 49.0], [55.0, 49.0], [55.1, 49.0], [55.2, 49.0], [55.3, 49.0], [55.4, 49.0], [55.5, 49.0], [55.6, 49.0], [55.7, 49.0], [55.8, 49.0], [55.9, 49.0], [56.0, 49.0], [56.1, 49.0], [56.2, 49.0], [56.3, 49.0], [56.4, 49.0], [56.5, 49.0], [56.6, 49.0], [56.7, 49.0], [56.8, 49.0], [56.9, 49.0], [57.0, 49.0], [57.1, 49.0], [57.2, 49.0], [57.3, 49.0], [57.4, 49.0], [57.5, 49.0], [57.6, 49.0], [57.7, 49.0], [57.8, 49.0], [57.9, 49.0], [58.0, 49.0], [58.1, 49.0], [58.2, 49.0], [58.3, 49.0], [58.4, 49.0], [58.5, 49.0], [58.6, 49.0], [58.7, 49.0], [58.8, 49.0], [58.9, 50.0], [59.0, 50.0], [59.1, 50.0], [59.2, 50.0], [59.3, 50.0], [59.4, 50.0], [59.5, 50.0], [59.6, 50.0], [59.7, 50.0], [59.8, 50.0], [59.9, 50.0], [60.0, 50.0], [60.1, 50.0], [60.2, 50.0], [60.3, 50.0], [60.4, 50.0], [60.5, 50.0], [60.6, 50.0], [60.7, 50.0], [60.8, 50.0], [60.9, 50.0], [61.0, 50.0], [61.1, 50.0], [61.2, 50.0], [61.3, 50.0], [61.4, 50.0], [61.5, 50.0], [61.6, 50.0], [61.7, 50.0], [61.8, 50.0], [61.9, 50.0], [62.0, 50.0], [62.1, 50.0], [62.2, 50.0], [62.3, 50.0], [62.4, 50.0], [62.5, 50.0], [62.6, 50.0], [62.7, 50.0], [62.8, 50.0], [62.9, 50.0], [63.0, 51.0], [63.1, 51.0], [63.2, 51.0], [63.3, 51.0], [63.4, 51.0], [63.5, 51.0], [63.6, 51.0], [63.7, 51.0], [63.8, 51.0], [63.9, 51.0], [64.0, 51.0], [64.1, 51.0], [64.2, 51.0], [64.3, 51.0], [64.4, 51.0], [64.5, 51.0], [64.6, 51.0], [64.7, 51.0], [64.8, 51.0], [64.9, 51.0], [65.0, 51.0], [65.1, 51.0], [65.2, 51.0], [65.3, 51.0], [65.4, 51.0], [65.5, 51.0], [65.6, 51.0], [65.7, 51.0], [65.8, 51.0], [65.9, 51.0], [66.0, 51.0], [66.1, 51.0], [66.2, 51.0], [66.3, 51.0], [66.4, 51.0], [66.5, 51.0], [66.6, 51.0], [66.7, 51.0], [66.8, 51.0], [66.9, 51.0], [67.0, 51.0], [67.1, 51.0], [67.2, 51.0], [67.3, 52.0], [67.4, 52.0], [67.5, 52.0], [67.6, 52.0], [67.7, 52.0], [67.8, 52.0], [67.9, 52.0], [68.0, 52.0], [68.1, 52.0], [68.2, 52.0], [68.3, 52.0], [68.4, 52.0], [68.5, 52.0], [68.6, 52.0], [68.7, 52.0], [68.8, 52.0], [68.9, 52.0], [69.0, 53.0], [69.1, 53.0], [69.2, 53.0], [69.3, 53.0], [69.4, 53.0], [69.5, 53.0], [69.6, 53.0], [69.7, 53.0], [69.8, 53.0], [69.9, 54.0], [70.0, 54.0], [70.1, 54.0], [70.2, 54.0], [70.3, 54.0], [70.4, 54.0], [70.5, 54.0], [70.6, 54.0], [70.7, 55.0], [70.8, 55.0], [70.9, 55.0], [71.0, 55.0], [71.1, 55.0], [71.2, 55.0], [71.3, 55.0], [71.4, 55.0], [71.5, 55.0], [71.6, 55.0], [71.7, 56.0], [71.8, 56.0], [71.9, 56.0], [72.0, 56.0], [72.1, 56.0], [72.2, 56.0], [72.3, 56.0], [72.4, 56.0], [72.5, 56.0], [72.6, 56.0], [72.7, 56.0], [72.8, 56.0], [72.9, 57.0], [73.0, 57.0], [73.1, 57.0], [73.2, 57.0], [73.3, 57.0], [73.4, 58.0], [73.5, 58.0], [73.6, 58.0], [73.7, 58.0], [73.8, 58.0], [73.9, 58.0], [74.0, 59.0], [74.1, 60.0], [74.2, 60.0], [74.3, 60.0], [74.4, 60.0], [74.5, 60.0], [74.6, 61.0], [74.7, 61.0], [74.8, 61.0], [74.9, 61.0], [75.0, 62.0], [75.1, 62.0], [75.2, 62.0], [75.3, 62.0], [75.4, 62.0], [75.5, 62.0], [75.6, 62.0], [75.7, 62.0], [75.8, 62.0], [75.9, 62.0], [76.0, 62.0], [76.1, 67.0], [76.2, 70.0], [76.3, 79.0], [76.4, 79.0], [76.5, 79.0], [76.6, 79.0], [76.7, 79.0], [76.8, 79.0], [76.9, 80.0], [77.0, 82.0], [77.1, 82.0], [77.2, 82.0], [77.3, 83.0], [77.4, 84.0], [77.5, 84.0], [77.6, 86.0], [77.7, 86.0], [77.8, 86.0], [77.9, 87.0], [78.0, 87.0], [78.1, 87.0], [78.2, 87.0], [78.3, 87.0], [78.4, 87.0], [78.5, 87.0], [78.6, 90.0], [78.7, 90.0], [78.8, 90.0], [78.9, 91.0], [79.0, 91.0], [79.1, 93.0], [79.2, 93.0], [79.3, 93.0], [79.4, 94.0], [79.5, 94.0], [79.6, 95.0], [79.7, 95.0], [79.8, 95.0], [79.9, 95.0], [80.0, 95.0], [80.1, 95.0], [80.2, 96.0], [80.3, 96.0], [80.4, 96.0], [80.5, 96.0], [80.6, 96.0], [80.7, 96.0], [80.8, 96.0], [80.9, 97.0], [81.0, 97.0], [81.1, 97.0], [81.2, 97.0], [81.3, 97.0], [81.4, 97.0], [81.5, 97.0], [81.6, 97.0], [81.7, 97.0], [81.8, 97.0], [81.9, 97.0], [82.0, 97.0], [82.1, 97.0], [82.2, 97.0], [82.3, 98.0], [82.4, 98.0], [82.5, 98.0], [82.6, 98.0], [82.7, 98.0], [82.8, 98.0], [82.9, 98.0], [83.0, 99.0], [83.1, 99.0], [83.2, 99.0], [83.3, 99.0], [83.4, 99.0], [83.5, 99.0], [83.6, 99.0], [83.7, 99.0], [83.8, 99.0], [83.9, 99.0], [84.0, 99.0], [84.1, 99.0], [84.2, 99.0], [84.3, 99.0], [84.4, 100.0], [84.5, 100.0], [84.6, 100.0], [84.7, 100.0], [84.8, 100.0], [84.9, 102.0], [85.0, 102.0], [85.1, 102.0], [85.2, 102.0], [85.3, 102.0], [85.4, 102.0], [85.5, 102.0], [85.6, 103.0], [85.7, 103.0], [85.8, 103.0], [85.9, 103.0], [86.0, 103.0], [86.1, 103.0], [86.2, 103.0], [86.3, 103.0], [86.4, 103.0], [86.5, 103.0], [86.6, 103.0], [86.7, 103.0], [86.8, 103.0], [86.9, 103.0], [87.0, 103.0], [87.1, 103.0], [87.2, 103.0], [87.3, 103.0], [87.4, 103.0], [87.5, 103.0], [87.6, 103.0], [87.7, 104.0], [87.8, 104.0], [87.9, 104.0], [88.0, 104.0], [88.1, 105.0], [88.2, 105.0], [88.3, 105.0], [88.4, 105.0], [88.5, 106.0], [88.6, 107.0], [88.7, 108.0], [88.8, 108.0], [88.9, 108.0], [89.0, 108.0], [89.1, 108.0], [89.2, 109.0], [89.3, 109.0], [89.4, 131.0], [89.5, 132.0], [89.6, 133.0], [89.7, 134.0], [89.8, 134.0], [89.9, 134.0], [90.0, 134.0], [90.1, 134.0], [90.2, 135.0], [90.3, 135.0], [90.4, 135.0], [90.5, 135.0], [90.6, 135.0], [90.7, 135.0], [90.8, 135.0], [90.9, 135.0], [91.0, 136.0], [91.1, 137.0], [91.2, 137.0], [91.3, 137.0], [91.4, 137.0], [91.5, 137.0], [91.6, 137.0], [91.7, 137.0], [91.8, 138.0], [91.9, 138.0], [92.0, 138.0], [92.1, 139.0], [92.2, 139.0], [92.3, 139.0], [92.4, 140.0], [92.5, 140.0], [92.6, 140.0], [92.7, 140.0], [92.8, 140.0], [92.9, 140.0], [93.0, 141.0], [93.1, 141.0], [93.2, 141.0], [93.3, 141.0], [93.4, 141.0], [93.5, 141.0], [93.6, 142.0], [93.7, 143.0], [93.8, 144.0], [93.9, 144.0], [94.0, 144.0], [94.1, 144.0], [94.2, 145.0], [94.3, 145.0], [94.4, 145.0], [94.5, 145.0], [94.6, 146.0], [94.7, 146.0], [94.8, 146.0], [94.9, 146.0], [95.0, 147.0], [95.1, 148.0], [95.2, 148.0], [95.3, 151.0], [95.4, 153.0], [95.5, 153.0], [95.6, 154.0], [95.7, 156.0], [95.8, 157.0], [95.9, 159.0], [96.0, 169.0], [96.1, 171.0], [96.2, 171.0], [96.3, 178.0], [96.4, 195.0], [96.5, 203.0], [96.6, 205.0], [96.7, 207.0], [96.8, 213.0], [96.9, 214.0], [97.0, 214.0], [97.1, 214.0], [97.2, 216.0], [97.3, 216.0], [97.4, 226.0], [97.5, 228.0], [97.6, 230.0], [97.7, 271.0], [97.8, 274.0], [97.9, 277.0], [98.0, 302.0], [98.1, 308.0], [98.2, 311.0], [98.3, 312.0], [98.4, 316.0], [98.5, 316.0], [98.6, 316.0], [98.7, 318.0], [98.8, 321.0], [98.9, 323.0], [99.0, 323.0], [99.1, 324.0], [99.2, 332.0], [99.3, 354.0], [99.4, 405.0], [99.5, 422.0], [99.6, 476.0], [99.7, 514.0], [99.8, 523.0], [99.9, 547.0]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "maxX": 100.0, "title": "Response Time Percentiles"}},
        getOptions: function() {
            return {
                series: {
                    points: { show: false }
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimePercentiles'
                },
                xaxis: {
                    tickDecimals: 1,
                    axisLabel: "Percentiles",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Percentile value in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : %x.2 percentile was %y ms"
                },
                selection: { mode: "xy" },
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesResponseTimePercentiles"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimesPercentiles"), dataset, options);
            // setup overview
            $.plot($("#overviewResponseTimesPercentiles"), dataset, prepareOverviewOptions(options));
        }
};

/**
 * @param elementId Id of element where we display message
 */
function setEmptyGraph(elementId) {
    $(function() {
        $(elementId).text("No graph series with filter="+seriesFilter);
    });
}

// Response times percentiles
function refreshResponseTimePercentiles() {
    var infos = responseTimePercentilesInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimePercentiles");
        return;
    }
    if (isGraph($("#flotResponseTimesPercentiles"))){
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesResponseTimePercentiles");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimesPercentiles", "#overviewResponseTimesPercentiles");
        $('#bodyResponseTimePercentiles .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var responseTimeDistributionInfos = {
        data: {"result": {"minY": 3.0, "minX": 0.0, "maxY": 844.0, "series": [{"data": [[0.0, 844.0], [300.0, 14.0], [400.0, 3.0], [200.0, 15.0], [100.0, 121.0], [500.0, 3.0]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 100, "maxX": 500.0, "title": "Response Time Distribution"}},
        getOptions: function() {
            var granularity = this.data.result.granularity;
            return {
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimeDistribution'
                },
                xaxis:{
                    axisLabel: "Response times in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of responses",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                bars : {
                    show: true,
                    barWidth: this.data.result.granularity
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: function(label, xval, yval, flotItem){
                        return yval + " responses for " + label + " were between " + xval + " and " + (xval + granularity) + " ms";
                    }
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimeDistribution"), prepareData(data.result.series, $("#choicesResponseTimeDistribution")), options);
        }

};

// Response time distribution
function refreshResponseTimeDistribution() {
    var infos = responseTimeDistributionInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimeDistribution");
        return;
    }
    if (isGraph($("#flotResponseTimeDistribution"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesResponseTimeDistribution");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        $('#footerResponseTimeDistribution .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var syntheticResponseTimeDistributionInfos = {
        data: {"result": {"minY": 3.0, "minX": 0.0, "ticks": [[0, "Requests having \nresponse time <= 500ms"], [1, "Requests having \nresponse time > 500ms and <= 1,500ms"], [2, "Requests having \nresponse time > 1,500ms"], [3, "Requests in error"]], "maxY": 997.0, "series": [{"data": [[0.0, 997.0]], "color": "#9ACD32", "isOverall": false, "label": "Requests having \nresponse time <= 500ms", "isController": false}, {"data": [[1.0, 3.0]], "color": "yellow", "isOverall": false, "label": "Requests having \nresponse time > 500ms and <= 1,500ms", "isController": false}, {"data": [], "color": "orange", "isOverall": false, "label": "Requests having \nresponse time > 1,500ms", "isController": false}, {"data": [], "color": "#FF6347", "isOverall": false, "label": "Requests in error", "isController": false}], "supportsControllersDiscrimination": false, "maxX": 1.0, "title": "Synthetic Response Times Distribution"}},
        getOptions: function() {
            return {
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendSyntheticResponseTimeDistribution'
                },
                xaxis:{
                    axisLabel: "Response times ranges",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                    tickLength:0,
                    min:-0.5,
                    max:3.5
                },
                yaxis: {
                    axisLabel: "Number of responses",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                bars : {
                    show: true,
                    align: "center",
                    barWidth: 0.25,
                    fill:.75
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: function(label, xval, yval, flotItem){
                        return yval + " " + label;
                    }
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var options = this.getOptions();
            prepareOptions(options, data);
            options.xaxis.ticks = data.result.ticks;
            $.plot($("#flotSyntheticResponseTimeDistribution"), prepareData(data.result.series, $("#choicesSyntheticResponseTimeDistribution")), options);
        }

};

// Response time distribution
function refreshSyntheticResponseTimeDistribution() {
    var infos = syntheticResponseTimeDistributionInfos;
    prepareSeries(infos.data, true);
    if (isGraph($("#flotSyntheticResponseTimeDistribution"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesSyntheticResponseTimeDistribution");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        $('#footerSyntheticResponseTimeDistribution .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var activeThreadsOverTimeInfos = {
        data: {"result": {"minY": 7.352999999999996, "minX": 1.76599068E12, "maxY": 7.352999999999996, "series": [{"data": [[1.76599068E12, 7.352999999999996]], "isOverall": false, "label": "First TP", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.76599068E12, "title": "Active Threads Over Time"}},
        getOptions: function() {
            return {
                series: {
                    stack: true,
                    lines: {
                        show: true,
                        fill: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of active threads",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 6,
                    show: true,
                    container: '#legendActiveThreadsOverTime'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                selection: {
                    mode: 'xy'
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : At %x there were %y active threads"
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesActiveThreadsOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotActiveThreadsOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewActiveThreadsOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Active Threads Over Time
function refreshActiveThreadsOverTime(fixTimestamps) {
    var infos = activeThreadsOverTimeInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -21600000);
    }
    if(isGraph($("#flotActiveThreadsOverTime"))) {
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesActiveThreadsOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotActiveThreadsOverTime", "#overviewActiveThreadsOverTime");
        $('#footerActiveThreadsOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var timeVsThreadsInfos = {
        data: {"result": {"minY": 46.5, "minX": 1.0, "maxY": 121.6, "series": [{"data": [[8.0, 64.03191489361699], [2.0, 46.666666666666664], [9.0, 89.07142857142857], [10.0, 84.7246376811594], [11.0, 90.76470588235296], [12.0, 112.75], [3.0, 53.375], [13.0, 121.6], [14.0, 106.27272727272728], [15.0, 120.91666666666667], [16.0, 112.61538461538461], [4.0, 48.25], [1.0, 46.5], [5.0, 49.97169811320755], [6.0, 62.221052631578964], [7.0, 73.84615384615383]], "isOverall": false, "label": "HTTP Request", "isController": false}, {"data": [[7.352999999999996, 70.36800000000002]], "isOverall": false, "label": "HTTP Request-Aggregated", "isController": false}], "supportsControllersDiscrimination": true, "maxX": 16.0, "title": "Time VS Threads"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    axisLabel: "Number of active threads",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average response times in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: { noColumns: 2,show: true, container: '#legendTimeVsThreads' },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s: At %x.2 active threads, Average response time was %y.2 ms"
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesTimeVsThreads"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotTimesVsThreads"), dataset, options);
            // setup overview
            $.plot($("#overviewTimesVsThreads"), dataset, prepareOverviewOptions(options));
        }
};

// Time vs threads
function refreshTimeVsThreads(){
    var infos = timeVsThreadsInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyTimeVsThreads");
        return;
    }
    if(isGraph($("#flotTimesVsThreads"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesTimeVsThreads");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTimesVsThreads", "#overviewTimesVsThreads");
        $('#footerTimeVsThreads .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var bytesThroughputOverTimeInfos = {
        data : {"result": {"minY": 2283.3333333333335, "minX": 1.76599068E12, "maxY": 25250.033333333333, "series": [{"data": [[1.76599068E12, 25250.033333333333]], "isOverall": false, "label": "Bytes received per second", "isController": false}, {"data": [[1.76599068E12, 2283.3333333333335]], "isOverall": false, "label": "Bytes sent per second", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.76599068E12, "title": "Bytes Throughput Over Time"}},
        getOptions : function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity) ,
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Bytes / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendBytesThroughputOverTime'
                },
                selection: {
                    mode: "xy"
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y"
                }
            };
        },
        createGraph : function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesBytesThroughputOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotBytesThroughputOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewBytesThroughputOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Bytes throughput Over Time
function refreshBytesThroughputOverTime(fixTimestamps) {
    var infos = bytesThroughputOverTimeInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -21600000);
    }
    if(isGraph($("#flotBytesThroughputOverTime"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesBytesThroughputOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotBytesThroughputOverTime", "#overviewBytesThroughputOverTime");
        $('#footerBytesThroughputOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var responseTimesOverTimeInfos = {
        data: {"result": {"minY": 70.36800000000002, "minX": 1.76599068E12, "maxY": 70.36800000000002, "series": [{"data": [[1.76599068E12, 70.36800000000002]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.76599068E12, "title": "Response Time Over Time"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average response time in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimesOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Average response time was %y ms"
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesResponseTimesOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimesOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewResponseTimesOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Response Times Over Time
function refreshResponseTimeOverTime(fixTimestamps) {
    var infos = responseTimesOverTimeInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimeOverTime");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -21600000);
    }
    if(isGraph($("#flotResponseTimesOverTime"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesResponseTimesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimesOverTime", "#overviewResponseTimesOverTime");
        $('#footerResponseTimesOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var latenciesOverTimeInfos = {
        data: {"result": {"minY": 69.93900000000005, "minX": 1.76599068E12, "maxY": 69.93900000000005, "series": [{"data": [[1.76599068E12, 69.93900000000005]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.76599068E12, "title": "Latencies Over Time"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average response latencies in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendLatenciesOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Average latency was %y ms"
                }
            };
        },
        createGraph: function () {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesLatenciesOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotLatenciesOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewLatenciesOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Latencies Over Time
function refreshLatenciesOverTime(fixTimestamps) {
    var infos = latenciesOverTimeInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyLatenciesOverTime");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -21600000);
    }
    if(isGraph($("#flotLatenciesOverTime"))) {
        infos.createGraph();
    }else {
        var choiceContainer = $("#choicesLatenciesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotLatenciesOverTime", "#overviewLatenciesOverTime");
        $('#footerLatenciesOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var connectTimeOverTimeInfos = {
        data: {"result": {"minY": 13.157000000000004, "minX": 1.76599068E12, "maxY": 13.157000000000004, "series": [{"data": [[1.76599068E12, 13.157000000000004]], "isOverall": false, "label": "HTTP Request", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.76599068E12, "title": "Connect Time Over Time"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getConnectTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average Connect Time in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendConnectTimeOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Average connect time was %y ms"
                }
            };
        },
        createGraph: function () {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesConnectTimeOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotConnectTimeOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewConnectTimeOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Connect Time Over Time
function refreshConnectTimeOverTime(fixTimestamps) {
    var infos = connectTimeOverTimeInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyConnectTimeOverTime");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -21600000);
    }
    if(isGraph($("#flotConnectTimeOverTime"))) {
        infos.createGraph();
    }else {
        var choiceContainer = $("#choicesConnectTimeOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotConnectTimeOverTime", "#overviewConnectTimeOverTime");
        $('#footerConnectTimeOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var responseTimePercentilesOverTimeInfos = {
        data: {"result": {"minY": 42.0, "minX": 1.76599068E12, "maxY": 547.0, "series": [{"data": [[1.76599068E12, 547.0]], "isOverall": false, "label": "Max", "isController": false}, {"data": [[1.76599068E12, 42.0]], "isOverall": false, "label": "Min", "isController": false}, {"data": [[1.76599068E12, 134.0]], "isOverall": false, "label": "90th percentile", "isController": false}, {"data": [[1.76599068E12, 323.0]], "isOverall": false, "label": "99th percentile", "isController": false}, {"data": [[1.76599068E12, 48.0]], "isOverall": false, "label": "Median", "isController": false}, {"data": [[1.76599068E12, 146.94999999999993]], "isOverall": false, "label": "95th percentile", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.76599068E12, "title": "Response Time Percentiles Over Time (successful requests only)"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true,
                        fill: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Response Time in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimePercentilesOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Response time was %y ms"
                }
            };
        },
        createGraph: function () {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesResponseTimePercentilesOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimePercentilesOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewResponseTimePercentilesOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Response Time Percentiles Over Time
function refreshResponseTimePercentilesOverTime(fixTimestamps) {
    var infos = responseTimePercentilesOverTimeInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -21600000);
    }
    if(isGraph($("#flotResponseTimePercentilesOverTime"))) {
        infos.createGraph();
    }else {
        var choiceContainer = $("#choicesResponseTimePercentilesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimePercentilesOverTime", "#overviewResponseTimePercentilesOverTime");
        $('#footerResponseTimePercentilesOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var responseTimeVsRequestInfos = {
    data: {"result": {"minY": 46.0, "minX": 26.0, "maxY": 99.0, "series": [{"data": [[33.0, 46.0], [93.0, 48.0], [98.0, 47.0], [101.0, 48.0], [103.0, 46.0], [26.0, 98.0], [105.0, 47.0], [108.0, 47.0], [113.0, 99.0], [122.0, 51.0]], "isOverall": false, "label": "Successes", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 1000, "maxX": 122.0, "title": "Response Time Vs Request"}},
    getOptions: function() {
        return {
            series: {
                lines: {
                    show: false
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                axisLabel: "Global number of requests per second",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Median Response Time in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: {
                noColumns: 2,
                show: true,
                container: '#legendResponseTimeVsRequest'
            },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : Median response time at %x req/s was %y ms"
            },
            colors: ["#9ACD32", "#FF6347"]
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesResponseTimeVsRequest"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotResponseTimeVsRequest"), dataset, options);
        // setup overview
        $.plot($("#overviewResponseTimeVsRequest"), dataset, prepareOverviewOptions(options));

    }
};

// Response Time vs Request
function refreshResponseTimeVsRequest() {
    var infos = responseTimeVsRequestInfos;
    prepareSeries(infos.data);
    if (isGraph($("#flotResponseTimeVsRequest"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesResponseTimeVsRequest");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimeVsRequest", "#overviewResponseTimeVsRequest");
        $('#footerResponseRimeVsRequest .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var latenciesVsRequestInfos = {
    data: {"result": {"minY": 46.0, "minX": 26.0, "maxY": 99.0, "series": [{"data": [[33.0, 46.0], [93.0, 48.0], [98.0, 47.0], [101.0, 48.0], [103.0, 46.0], [26.0, 98.0], [105.0, 47.0], [108.0, 47.0], [113.0, 99.0], [122.0, 51.0]], "isOverall": false, "label": "Successes", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 1000, "maxX": 122.0, "title": "Latencies Vs Request"}},
    getOptions: function() {
        return{
            series: {
                lines: {
                    show: false
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                axisLabel: "Global number of requests per second",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Median Latency in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: { noColumns: 2,show: true, container: '#legendLatencyVsRequest' },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : Median Latency time at %x req/s was %y ms"
            },
            colors: ["#9ACD32", "#FF6347"]
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesLatencyVsRequest"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotLatenciesVsRequest"), dataset, options);
        // setup overview
        $.plot($("#overviewLatenciesVsRequest"), dataset, prepareOverviewOptions(options));
    }
};

// Latencies vs Request
function refreshLatenciesVsRequest() {
        var infos = latenciesVsRequestInfos;
        prepareSeries(infos.data);
        if(isGraph($("#flotLatenciesVsRequest"))){
            infos.createGraph();
        }else{
            var choiceContainer = $("#choicesLatencyVsRequest");
            createLegend(choiceContainer, infos);
            infos.createGraph();
            setGraphZoomable("#flotLatenciesVsRequest", "#overviewLatenciesVsRequest");
            $('#footerLatenciesVsRequest .legendColorBox > div').each(function(i){
                $(this).clone().prependTo(choiceContainer.find("li").eq(i));
            });
        }
};

var hitsPerSecondInfos = {
        data: {"result": {"minY": 16.666666666666668, "minX": 1.76599068E12, "maxY": 16.666666666666668, "series": [{"data": [[1.76599068E12, 16.666666666666668]], "isOverall": false, "label": "hitsPerSecond", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.76599068E12, "title": "Hits Per Second"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of hits / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendHitsPerSecond"
                },
                selection: {
                    mode : 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y.2 hits/sec"
                }
            };
        },
        createGraph: function createGraph() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesHitsPerSecond"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotHitsPerSecond"), dataset, options);
            // setup overview
            $.plot($("#overviewHitsPerSecond"), dataset, prepareOverviewOptions(options));
        }
};

// Hits per second
function refreshHitsPerSecond(fixTimestamps) {
    var infos = hitsPerSecondInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -21600000);
    }
    if (isGraph($("#flotHitsPerSecond"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesHitsPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotHitsPerSecond", "#overviewHitsPerSecond");
        $('#footerHitsPerSecond .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var codesPerSecondInfos = {
        data: {"result": {"minY": 16.666666666666668, "minX": 1.76599068E12, "maxY": 16.666666666666668, "series": [{"data": [[1.76599068E12, 16.666666666666668]], "isOverall": false, "label": "200", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.76599068E12, "title": "Codes Per Second"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of responses / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendCodesPerSecond"
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "Number of Response Codes %s at %x was %y.2 responses / sec"
                }
            };
        },
    createGraph: function() {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesCodesPerSecond"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotCodesPerSecond"), dataset, options);
        // setup overview
        $.plot($("#overviewCodesPerSecond"), dataset, prepareOverviewOptions(options));
    }
};

// Codes per second
function refreshCodesPerSecond(fixTimestamps) {
    var infos = codesPerSecondInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -21600000);
    }
    if(isGraph($("#flotCodesPerSecond"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesCodesPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotCodesPerSecond", "#overviewCodesPerSecond");
        $('#footerCodesPerSecond .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var transactionsPerSecondInfos = {
        data: {"result": {"minY": 16.666666666666668, "minX": 1.76599068E12, "maxY": 16.666666666666668, "series": [{"data": [[1.76599068E12, 16.666666666666668]], "isOverall": false, "label": "HTTP Request-success", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.76599068E12, "title": "Transactions Per Second"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of transactions / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendTransactionsPerSecond"
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y transactions / sec"
                }
            };
        },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesTransactionsPerSecond"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotTransactionsPerSecond"), dataset, options);
        // setup overview
        $.plot($("#overviewTransactionsPerSecond"), dataset, prepareOverviewOptions(options));
    }
};

// Transactions per second
function refreshTransactionsPerSecond(fixTimestamps) {
    var infos = transactionsPerSecondInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyTransactionsPerSecond");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -21600000);
    }
    if(isGraph($("#flotTransactionsPerSecond"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesTransactionsPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTransactionsPerSecond", "#overviewTransactionsPerSecond");
        $('#footerTransactionsPerSecond .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var totalTPSInfos = {
        data: {"result": {"minY": 16.666666666666668, "minX": 1.76599068E12, "maxY": 16.666666666666668, "series": [{"data": [[1.76599068E12, 16.666666666666668]], "isOverall": false, "label": "Transaction-success", "isController": false}, {"data": [], "isOverall": false, "label": "Transaction-failure", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.76599068E12, "title": "Total Transactions Per Second"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of transactions / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendTotalTPS"
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y transactions / sec"
                },
                colors: ["#9ACD32", "#FF6347"]
            };
        },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesTotalTPS"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotTotalTPS"), dataset, options);
        // setup overview
        $.plot($("#overviewTotalTPS"), dataset, prepareOverviewOptions(options));
    }
};

// Total Transactions per second
function refreshTotalTPS(fixTimestamps) {
    var infos = totalTPSInfos;
    // We want to ignore seriesFilter
    prepareSeries(infos.data, false, true);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -21600000);
    }
    if(isGraph($("#flotTotalTPS"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesTotalTPS");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTotalTPS", "#overviewTotalTPS");
        $('#footerTotalTPS .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

// Collapse the graph matching the specified DOM element depending the collapsed
// status
function collapse(elem, collapsed){
    if(collapsed){
        $(elem).parent().find(".fa-chevron-up").removeClass("fa-chevron-up").addClass("fa-chevron-down");
    } else {
        $(elem).parent().find(".fa-chevron-down").removeClass("fa-chevron-down").addClass("fa-chevron-up");
        if (elem.id == "bodyBytesThroughputOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshBytesThroughputOverTime(true);
            }
            document.location.href="#bytesThroughputOverTime";
        } else if (elem.id == "bodyLatenciesOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshLatenciesOverTime(true);
            }
            document.location.href="#latenciesOverTime";
        } else if (elem.id == "bodyCustomGraph") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshCustomGraph(true);
            }
            document.location.href="#responseCustomGraph";
        } else if (elem.id == "bodyConnectTimeOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshConnectTimeOverTime(true);
            }
            document.location.href="#connectTimeOverTime";
        } else if (elem.id == "bodyResponseTimePercentilesOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimePercentilesOverTime(true);
            }
            document.location.href="#responseTimePercentilesOverTime";
        } else if (elem.id == "bodyResponseTimeDistribution") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimeDistribution();
            }
            document.location.href="#responseTimeDistribution" ;
        } else if (elem.id == "bodySyntheticResponseTimeDistribution") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshSyntheticResponseTimeDistribution();
            }
            document.location.href="#syntheticResponseTimeDistribution" ;
        } else if (elem.id == "bodyActiveThreadsOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshActiveThreadsOverTime(true);
            }
            document.location.href="#activeThreadsOverTime";
        } else if (elem.id == "bodyTimeVsThreads") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTimeVsThreads();
            }
            document.location.href="#timeVsThreads" ;
        } else if (elem.id == "bodyCodesPerSecond") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshCodesPerSecond(true);
            }
            document.location.href="#codesPerSecond";
        } else if (elem.id == "bodyTransactionsPerSecond") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTransactionsPerSecond(true);
            }
            document.location.href="#transactionsPerSecond";
        } else if (elem.id == "bodyTotalTPS") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTotalTPS(true);
            }
            document.location.href="#totalTPS";
        } else if (elem.id == "bodyResponseTimeVsRequest") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimeVsRequest();
            }
            document.location.href="#responseTimeVsRequest";
        } else if (elem.id == "bodyLatenciesVsRequest") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshLatenciesVsRequest();
            }
            document.location.href="#latencyVsRequest";
        }
    }
}

/*
 * Activates or deactivates all series of the specified graph (represented by id parameter)
 * depending on checked argument.
 */
function toggleAll(id, checked){
    var placeholder = document.getElementById(id);

    var cases = $(placeholder).find(':checkbox');
    cases.prop('checked', checked);
    $(cases).parent().children().children().toggleClass("legend-disabled", !checked);

    var choiceContainer;
    if ( id == "choicesBytesThroughputOverTime"){
        choiceContainer = $("#choicesBytesThroughputOverTime");
        refreshBytesThroughputOverTime(false);
    } else if(id == "choicesResponseTimesOverTime"){
        choiceContainer = $("#choicesResponseTimesOverTime");
        refreshResponseTimeOverTime(false);
    }else if(id == "choicesResponseCustomGraph"){
        choiceContainer = $("#choicesResponseCustomGraph");
        refreshCustomGraph(false);
    } else if ( id == "choicesLatenciesOverTime"){
        choiceContainer = $("#choicesLatenciesOverTime");
        refreshLatenciesOverTime(false);
    } else if ( id == "choicesConnectTimeOverTime"){
        choiceContainer = $("#choicesConnectTimeOverTime");
        refreshConnectTimeOverTime(false);
    } else if ( id == "choicesResponseTimePercentilesOverTime"){
        choiceContainer = $("#choicesResponseTimePercentilesOverTime");
        refreshResponseTimePercentilesOverTime(false);
    } else if ( id == "choicesResponseTimePercentiles"){
        choiceContainer = $("#choicesResponseTimePercentiles");
        refreshResponseTimePercentiles();
    } else if(id == "choicesActiveThreadsOverTime"){
        choiceContainer = $("#choicesActiveThreadsOverTime");
        refreshActiveThreadsOverTime(false);
    } else if ( id == "choicesTimeVsThreads"){
        choiceContainer = $("#choicesTimeVsThreads");
        refreshTimeVsThreads();
    } else if ( id == "choicesSyntheticResponseTimeDistribution"){
        choiceContainer = $("#choicesSyntheticResponseTimeDistribution");
        refreshSyntheticResponseTimeDistribution();
    } else if ( id == "choicesResponseTimeDistribution"){
        choiceContainer = $("#choicesResponseTimeDistribution");
        refreshResponseTimeDistribution();
    } else if ( id == "choicesHitsPerSecond"){
        choiceContainer = $("#choicesHitsPerSecond");
        refreshHitsPerSecond(false);
    } else if(id == "choicesCodesPerSecond"){
        choiceContainer = $("#choicesCodesPerSecond");
        refreshCodesPerSecond(false);
    } else if ( id == "choicesTransactionsPerSecond"){
        choiceContainer = $("#choicesTransactionsPerSecond");
        refreshTransactionsPerSecond(false);
    } else if ( id == "choicesTotalTPS"){
        choiceContainer = $("#choicesTotalTPS");
        refreshTotalTPS(false);
    } else if ( id == "choicesResponseTimeVsRequest"){
        choiceContainer = $("#choicesResponseTimeVsRequest");
        refreshResponseTimeVsRequest();
    } else if ( id == "choicesLatencyVsRequest"){
        choiceContainer = $("#choicesLatencyVsRequest");
        refreshLatenciesVsRequest();
    }
    var color = checked ? "black" : "#818181";
    if(choiceContainer != null) {
        choiceContainer.find("label").each(function(){
            this.style.color = color;
        });
    }
}

