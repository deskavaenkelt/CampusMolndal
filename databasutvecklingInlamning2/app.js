const MongoClient = require('mongodb').MongoClient;
const assert = require('assert');

// Connection URL
const url = 'mongodb://localhost:27017';

// Database Name
const dbName = 'databasutvecklinginlamning2';

// Use connect method to connect to the server
MongoClient.connect(url, function(err, client) {
    assert.equal(null, err);
    console.log("Connected successfully to server");

    const db = client.db(dbName);

    // run
    insertItem(db, function () {
        findAll(db, function () {
            findSpecificItem(db, function () {
                updateItem(db, function () {
                    addFavorite(db, function () {
                        findFavorites(db, function () {
                            removeItem(db, function () {
                                findAll(db, function () {
                                    client.close();
                                });
                            });
                        });
                    });
                });
            });
        });
    });

    // Delete all
    /*removeAll(db, function () {
        findAll(db, function () {
            client.close();
        });
    });*/
});

const insertItem = function(db, callback) {
    // Get the documents collection
    const collection = db.collection('Handlingslista');
    // Insert some documents
    collection.insertMany([
        {
            item: 'milk',
            qty: 4,
            tags: ['regular', 'red'],
            size: { st: 1, uom: 'liters' }
        },
        {
            item: 'snickers',
            qty: 12,
            tags: ['plasticily'],
            size: { st: 12, uom: 'quantity' }
        },
        {
            item: 'popcorn',
            qty: 3,
            tags: ['micro', 'smelly'],
            size: { st: 1, uom: 'bag' }
        }
    ], function(err, result) {
        assert.equal(err, null);
        assert.equal(3, result.result.n);
        assert.equal(3, result.ops.length);
        console.log("Inserted 3 items to Handlingslista");
        callback(result);
    });
};

const findAll = function(db, callback) {
    // Get the documents collection
    const collection = db.collection('Handlingslista');
    // Find some documents
    collection.find({}).toArray(function(err, docs) {
        assert.equal(err, null);
        console.log("Found the following items");
        console.log(docs);
        callback(docs);
    });
};

const findSpecificItem = function(db, callback) {
    // Get the documents collection
    const collection = db.collection('Handlingslista');
    // Find some documents
    collection.find({ item: 'milk' }).toArray(function(err, docs) {
        assert.equal(err, null);
        console.log("Found specific item");
        console.log(docs);
        callback(docs);
    });
};

const updateItem = function(db, callback) {
    // Get the documents collection
    const collection = db.collection('Handlingslista');
    // Update document where a is 2, set b equal to 1
    collection.updateOne(
        {
            item: 'popcorn',
            qty: 3,
            tags: ['micro', 'smelly'],
            size: { st: 1, uom: 'bag' }
        }
        , { $set:
                {
                    item: 'popcornXL',
                    qty: 1,
                    tags: ['regular', 'jummy'],
                    size: { st: 1, uom: 'xlbag' }
                }
                }, function(err, result) {
            assert.equal(err, null);
            assert.equal(1, result.result.n);
            console.log("Updated popcorn with something new");
            callback(result);
        });
};

const addFavorite = function(db, callback) {
    // Get the documents collection
    const collection = db.collection('Handlingslista');
    // Update document where a is 2, set b equal to 1
    collection.updateOne(
        {
            item: 'milk'
        }
        , { $set:
                {
                    fav: 'favorite'
                }
        }, function(err, result) {
            assert.equal(err, null);
            assert.equal(1, result.result.n);
            console.log("Added favorite");
            callback(result);
        });
};

const findFavorites = function(db, callback) {
    // Get the documents collection
    const collection = db.collection('Handlingslista');
    // Find some documents
    collection.find({ fav: 'favorite' }).toArray(function(err, docs) {
        assert.equal(err, null);
        console.log("Found the following favorites");
        console.log(docs);
        callback(docs);
    });
};

const removeItem = function(db, callback) {
    // Get the documents collection
    const collection = db.collection('Handlingslista');
    // Delete document where a is 3
    collection.deleteOne(
        {
            item: 'snickers',
            qty: 12,
            tags: ['plasticily'],
            size: { st: 12, uom: 'quantity' }
        }
        , function(err, result) {
        assert.equal(err, null);
        assert.equal(1, result.result.n);
        console.log("Removed the item snickers");
        callback(result);
    });
};

const removeAll = function(db, callback) {
    // Get the documents collection
    const collection = db.collection('Handlingslista');
    // Delete All
    collection.deleteOne(
        {}
        , function(err, result) {
            assert.equal(err, null);
            assert.equal(1, result.result.n);
            console.log("Removed the item snickers");
            callback(result);
        });
};