AppCard.Views.LoyaltyView = AppCard.Views.Base.extend ({
    template: '#merchant-loyalty-template',

    intialize: function() {
        console.log('initializing');
        AppCard.Views.Base.extend.prototype.initialize.call(this);
    },

    render: function()
    {
        var modelJson = this.model.toJSON();
        console.log('from view '+JSON.stringify(modelJson));
        //alert('stringify '+this.model);
        var content = this.template(modelJson);


        var onTempl = _.template( $("#present-on-template").html(), modelJson );
        var offTempl = _.template( $("#present-off-template").html(), modelJson );

        $(this.el).html(content);
        var presentContainer = this.$el.find('.presentContainer');
        var i = 0;
        while (i < modelJson.numOfPresents)
        {
            presentContainer.append(onTempl);
            i++;
        }

        presentContainer.append(offTempl);

        return this;
    }
});

AppCard.Views.MerchantInfoView = AppCard.Views.Base.extend ({
    template: '#merchant-info-template',

    intialize: function() {
        console.log('initializing');
        AppCard.Views.Base.extend.prototype.initialize.call(this);
    },

    events: {
        'click .seeOtherBranchesContainer': 'showBranches'
    },

    showBranches: function(){
        Backbone.history.navigate('/stores/52/info/branches', true);
    },

    render: function()
    {
        var modelJson = this.model.toJSON();
        console.log('from view '+JSON.stringify(modelJson));
        //alert('stringify '+this.model);
        var content = this.template(modelJson);
        console.log('rendering merchant-info-template');

        $(this.el).html(content);
        this.initializeMap(modelJson);
        return this;
    },

    initializeMap: function(modelJson)
    {
        loc = String(modelJson.data.branches[0].location).split(',');
        console.log("location is %s and %s", loc[0], loc[1]);
        var myOptions =
        {
            center: new google.maps.LatLng(loc[0], loc[1]),
            zoom: 16,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var mapDiv = (this.$el).find('.mapsDiv')[0];
        console.log('map is '+mapDiv);
        var map = new google.maps.Map(mapDiv, myOptions);
        map.draggable = false;
        title = modelJson.data.branches[0].name;
        id = modelJson.data.branches[0].beanchId;
        var latlng = new google.maps.LatLng(new Number(loc[0]), new Number(loc[1]));
        var marker = new google.maps.Marker({
            map: map,
            position: latlng,
            title: 'id=' + id + ', name=' + title
        });
    }
});

AppCard.Views.BranchesListView = AppCard.Views.Base.extend({

    tagName:'ul',

    initialize:function ()
    {
        this.collection.bind("reset", this.render, this);
    },

    render:function (eventName)
    {
        //var modelJson = this.model.toJSON();
        console.log('from view '+JSON.stringify(this.collection.toJSON()));

        _.each(this.collection, function (branch)
        {
            console.log('collection is '+this.collection);
            $(this.el).append(new AppCard.Views.BranchesListItemView({model:branch}).render().el);
        },
        this);
        return this;
    }

});

AppCard.Views.BranchesListItemView = AppCard.Views.Base.extend({

    tagName:"li",

    template:_.template($('#branch-list-item').html()),

    initialize:function ()
    {
    },

    render:function (eventName)
    {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }

});