/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*jslint  browser: true, white: true, plusplus: true */
        /*global $, films*/
        $(function () {
            'use strict';
            //var filmArray1 = 
            var filmArray = $.map(films, function (value, key) {
                return {value: value, data: key};
            });
            console.log(filmArray);
            // Initialize ajax autocomplete:
            $('#autocomplete').autocomplete({
                lookup: filmArray,
                lookupLimit: 10,
                minChars: 2,
                onSelect: function (suggestion) {
                    $('#selection-ajax').html('You selected: ' + suggestion.value + ', ' + suggestion.data);
                }});
        });
